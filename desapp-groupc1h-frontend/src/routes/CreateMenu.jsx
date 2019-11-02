import React from 'react'
import { injectIntl} from 'react-intl'

class CreateMenu  extends React.Component{

    render(){
        const intl = this.props.intl;
        const greet = intl.formatMessage({
          id: 'Greet',
          defaultMessage: 'hello'
        });
        const createMenu = intl.formatMessage({
            id: 'CreateMenu',
            defaultMessage: 'create menu'
          });
        return(
            <div className= "App" >
                <h1>{greet}</h1>
                <h1>{createMenu}</h1>
            </div>
        )
    }

}

CreateMenu = injectIntl(CreateMenu);

export default CreateMenu;