import React, { useEffect } from "react";
import {Route} from "react-router-dom";
import {useAuth0} from "../providers/Auth0Provider";

const PrivateRoute = ({ component: Component, path, ...rest }) => {
    const { loading, isAuthenticated, loginWithRedirect, getTokenSilently} = useAuth0();

    useEffect(() => {
        if (loading || isAuthenticated) {
            return;
        }
        
        const fn = async () => {
            await loginWithRedirect({
                appState: { targetUrl: path }
            });
        };
        fn();
    }, [path, loading, isAuthenticated, loginWithRedirect]);

    const render = props => isAuthenticated ? <Component getTokenSilently={getTokenSilently} {...props} /> : null;

    return <Route path={path} render={render} {...rest} />;
};

export default PrivateRoute;