import React from 'react';
import {Icon, Result} from 'antd';

const styleProps = {
    style: {
        fontSize: 50,
        color: '#ffffff'
    }
};

function Login() {

    return (
        <Result
            icon={ <Icon type="home"  {...styleProps}/>}
            title={<div {...styleProps}> Bienvenido! </div>}
        />
    );

}

export default Login;