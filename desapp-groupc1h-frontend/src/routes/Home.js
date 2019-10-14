import React from 'react'
import { injectIntl, intlShape } from 'react-intl'

class Home  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const home = intl.formatMessage({
            id: 'Home',
            defaultMessage: 'home'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{home}</h1>
            </div>
        )
    }

}

Home = injectIntl(Home)

export default Home;