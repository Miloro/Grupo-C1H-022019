import React from 'react'
import { injectIntl, intlShape } from 'react-intl'

class ServiceOrders  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const serviceOrders = intl.formatMessage({
            id: 'ServiceOrders',
            defaultMessage: 'Service orders'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{serviceOrders}</h1>
            </div>
        )
    }

}

ServiceOrders = injectIntl(ServiceOrders)

export default ServiceOrders;