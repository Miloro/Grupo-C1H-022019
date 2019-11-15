import React from 'react';
import {Button, Icon, Result} from 'antd';
import {useAuth0} from "../react-auth0-spa";

const styleProps = {
    style: {
        fontSize: 50,
        color: '#ffffff'
    }
};


const Login = () => {
    const {loginWithRedirect, loading} = useAuth0();



    return <Result
        icon={<Icon type="home"  {...styleProps}/>}
        title={<div {...styleProps}> Bienvenido! </div>}
        extra={!loading && <Button type="primary" size="large" onClick={() => loginWithRedirect({})}>
            Login
        </Button>}
    />;

};

export default Login;