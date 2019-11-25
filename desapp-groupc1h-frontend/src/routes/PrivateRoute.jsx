import React, { useEffect } from "react";
import {Route} from "react-router-dom";
import {useAuth0} from "../providers/Auth0Provider";
import {useUser} from "../providers/UserProvider";

const PrivateRoute = ({ component: Component, path, ...rest }) => {
    const { loading, isAuthenticated, loginWithRedirect, getTokenSilently} = useAuth0();
    const [user ,] = useUser();

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

    const render = props => isAuthenticated ? <Component getTokenSilently={getTokenSilently} user= {user}{...props} /> : null;

    return <Route path={path} render={render} {...rest} />;
};

export default PrivateRoute;