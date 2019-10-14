import React from 'react'
import { injectIntl, intlShape } from 'react-intl'

class Menus  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const menus = intl.formatMessage({
            id: 'Menus',
            defaultMessage: 'menus'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{menus}</h1>
            </div>
        )
    }

}

Menus = injectIntl(Menus)

export default Menus;