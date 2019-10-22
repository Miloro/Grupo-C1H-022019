import React from 'react'
import { injectIntl} from 'react-intl'

import FacebookLogin from 'react-facebook-login';
import GoogleLogin from 'react-google-login';

class LogIn  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'welcome'
        })
        const loginMessage = intl.formatMessage({
            id: 'LoginMessage',
            defaultMessage: 'LOGIN WITH FACEBOOK OR GOOGLE'
          })

        const responseFacebook = (response) => {
            console.log(response);
          }
      
        const responseGoogle = (response) => {
          console.log(response);
        }

        return(
            <div className= "App" >
                
                <h1>{greet}</h1>

                <h1>{loginMessage}</h1>

                <FacebookLogin
                appId="" //APP ID NOT CREATED YET
                fields="name,email,picture"
                callback={responseFacebook}
                />
                <br />
                <br />
                <GoogleLogin
                clientId="913660069829-879slc80rd35np4hj0bj4596bf0k4iim.apps.googleusercontent.com" //CLIENTID NOT CREATED YET
                buttonText="LOGIN WITH GOOGLE"
                onSuccess={responseGoogle}
                onFailure={responseGoogle}
                />
            </div>
        )
    }

                    
}
             
LogIn = injectIntl(LogIn)

export default LogIn;