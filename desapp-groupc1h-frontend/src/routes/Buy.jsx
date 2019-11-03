import React from 'react'
import { injectIntl} from 'react-intl'

class Buy  extends React.Component{

    render(){
        const intl = this.props.intl;
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        });
        const service = intl.formatMessage({
            id: 'buy',
            defaultMessage: 'buy'
          });
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{service}</h1>
            </div>
        )
    }

}

Buy = injectIntl(Buy);

export default Buy;