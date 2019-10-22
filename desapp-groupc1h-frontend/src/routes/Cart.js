import React from 'react'
import { injectIntl} from 'react-intl'

class Cart  extends React.Component{

    render(){
        const intl = this.props.intl
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        })
        const cart = intl.formatMessage({
            id: 'Cart',
            defaultMessage: 'cart'
          })
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{cart}</h1>
            </div>
        )
    }

}

Cart = injectIntl(Cart)

export default Cart;