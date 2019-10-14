import React from 'react'
import { injectIntl} from 'react-intl'

class LogIn  extends React.Component{

    render(){
        const language = navigator.language
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'no se mando'
        })
        return(
            <div className= "App" >
                <h1>buenas</h1>
                <h1>{language}</h1>
                <h1>{greet}</h1>
            </div>
        )
    }

}

LogIn = injectIntl(LogIn)

export default LogIn;