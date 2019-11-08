import React from 'react'
import { injectIntl} from 'react-intl'

class UnratedOrders  extends React.Component{

    render(){
        const intl = this.props.intl;
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        });
        const UnratedOrderds = intl.formatMessage({
            id: 'UnratedOrderds',
            defaultMessage: 'unrated orders'
          });
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{UnratedOrderds}</h1>
            </div>
        )
    }

}

UnratedOrders = injectIntl(UnratedOrders);

export default UnratedOrders;