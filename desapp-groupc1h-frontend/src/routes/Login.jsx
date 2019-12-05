import React from 'react';
import {Button, Icon, Result} from 'antd';
import {useAuth0} from "../providers/Auth0Provider";
import {FormattedMessage} from "react-intl";

const styleProps = {
    style: {
        fontSize: 50,
        color: '#ffffff'
    }
};

const Login = () => {
    const {loginWithRedirect, loading} = useAuth0();

    return <Result
        icon={<Icon type="home" {...styleProps}/>}
        title={<div {...styleProps}><FormattedMessage id="welcomeMessage"/></div>}
        extra={!loading &&
        <Button size="large" onClick={() => loginWithRedirect({})}>
            <FormattedMessage id="login"/>
        </Button>}
    />;

};

export default Login;