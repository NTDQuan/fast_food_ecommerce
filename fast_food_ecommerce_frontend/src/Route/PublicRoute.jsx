import React from 'react'

const PublicRoute = ({ component: Component, isAuthenticated, restricted, ...rest }) => {
    <Route
        {...rest}
        render={(props) => 
            isAuthenticated && restricted ? (
                <Redirect to="/" />
            ) : (
                <Component {...props} />
            )
        }
    />
}

export default PublicRoute
