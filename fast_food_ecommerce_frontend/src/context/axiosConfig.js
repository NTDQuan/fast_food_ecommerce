import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8080/api/v1',
    headers: {
        "Content-Type": "application/json"
    },
});

instance.interceptors.request.use((config) => {
    const token = localStorage.getItem('access_token');
    if (token) {
      config.headers["Authorization"] = 'Bearer ' + token;
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});

instance.interceptors.response.use(
  (res) => {
      return res;
  },
  async (err) => {
      const originalConfig = err.config;

      if (originalConfig.url !== "/auth/login" && originalConfig.url !== "/auth/refreshToken" && err.response) {
          // Access Token was expired
          if (err.response.status === 401 && !originalConfig._retry) {
              originalConfig._retry = true;

              try {
                  const refreshTokenRequestBody = { token: localStorage.getItem("refresh_token") };
                  console.log("Refreshing token with body:", refreshTokenRequestBody); // Debugging statement
                  const rs = await instance.post("/auth/refreshToken", refreshTokenRequestBody);
                  const { accessToken } = rs.data;
                  console.log("New Access Token:", accessToken); // Debugging statement
                  localStorage.setItem("access_token", accessToken);

                  return instance(originalConfig);
              } catch (_error) {
                  console.error("Refresh token failed:", _error); // Debugging statement
                  return Promise.reject(_error);
              }
          }
      }

      return Promise.reject(err);
  }
);

export default instance;