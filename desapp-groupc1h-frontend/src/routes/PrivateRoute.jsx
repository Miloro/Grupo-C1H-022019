import React, { useEffect } from "react";
import {Route, useHistory} from "react-router-dom";
import {useAuth0} from "../providers/Auth0Provider";
import {Col, Row} from "antd";
import {useUser} from "../providers/UserProvider";

const PrivateRoute = ({ component: Component, path, ...rest }) => {
    const { loading, isAuthenticated, loginWithRedirect, getTokenSilently} = useAuth0();
    const {clientId} = useUser();
    let history = useHistory();

    useEffect(() => {
        if (!(loading || isAuthenticated)) {
            // eslint-disable-next-line no-unused-vars
            const fn = async () => {
                await loginWithRedirect({
                    appState: { targetUrl: path }
                });
            fn();
        }}
        if(!loading && isAuthenticated && !clientId) {
            history.push("/user");
        }
    }, [path, loading, isAuthenticated, loginWithRedirect, clientId, history]);

    const render = props => {
        return isAuthenticated && clientId ?
            <Row type="flex" justify="space-around" align="middle">
                <Col span={20} style={{backgroundColor: "#ffffff"}}>
                <Component getTokenSilently={getTokenSilently}/>
                </Col>
            </Row>
             : null;
    };

    return <Route path={path} render={render} {...rest} />;
};

export default PrivateRoute;