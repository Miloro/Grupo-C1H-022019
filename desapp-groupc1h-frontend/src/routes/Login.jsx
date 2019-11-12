import React from 'react';
import GoogleLogin from 'react-google-login';
import {Icon, Result} from 'antd';

const styleProps = {
    style: {
        fontSize: 50,
        color: '#ffffff'
    }
};

function Login() {

    const responseGoogle = (response) => {
        console.log(response);
    };

    return (
        <Result
            icon={ <Icon type="home"  {...styleProps}/>}
            title={<div {...styleProps}> Bienvenido! </div>}
            extra={<GoogleLogin
                clientId={process.env.REACT_APP_GOOGLE_API_CLIENT_ID}
                buttonText="LOGIN WITH GOOGLE"
                onSuccess={responseGoogle}
                onFailure={responseGoogle}
            />}
        />
    );

}

export default Login;