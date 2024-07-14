import instance from '../context/axiosConfig';
import { AuthContext } from '../context/AuthContext';

const authentication = async (input) => {
    try {
        const response = await instance.post('/auth/login', input);
        if (response.data) {
            localStorage.setItem('access_token', response.data.accessToken);
            localStorage.setItem('refresh_token', response.data.token);
        }
        return response.data;
    } catch (error) {
        throw error;
    }
}

const logout = async () => {
    try {
        const response = await instance.post('/auth/logout');
        if (response.status === 200) {
            localStorage.removeItem('access_token');
            localStorage.removeItem('refresh_token');
        }
        return response.data;
    } catch (error) {
        throw error;
    }
}

export { authentication, logout };