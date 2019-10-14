import React from 'react'
import { injectIntl, intlShape } from 'react-intl'

class Service  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const service = intl.formatMessage({
            id: 'Service',
            defaultMessage: 'service'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{service}</h1>
            </div>
        )
    }

}

Service = injectIntl(Service)

export default Service;