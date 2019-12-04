import React from 'react';
import {Button, Icon, Result} from 'antd';
import {useAuth0} from "../providers/Auth0Provider";
import {FormattedMessage} from "react-intl";

const styleProps = {
    style: {
        fontSize: 50,
        color: '#FF8C00'
    }
};

const Login = () => {
    const {loginWithRedirect, loading} = useAuth0();

    return <Result
        icon={<Icon type="home"  {...styleProps}/>}
        title={<div {...styleProps}> <FormattedMessage id="welcome"/> </div>}
        extra={!loading && <Button type="primary" size="large" onClick={() => loginWithRedirect({})}>
            Login
        </Button>}
    />;

};

export default Login;