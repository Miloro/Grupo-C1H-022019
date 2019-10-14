import React from 'react'
import { injectIntl, intlShape } from 'react-intl'

class Orders  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const orders = intl.formatMessage({
            id: 'Orders',
            defaultMessage: 'orders'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{orders}</h1>
            </div>
        )
    }

}

Orders = injectIntl(Orders)

export default Orders;