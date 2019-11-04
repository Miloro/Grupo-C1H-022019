import React from 'react'
import { injectIntl} from 'react-intl'
import {Button} from 'react-bootstrap'
import {GetMenu} from "../api.jsx"

class Buy  extends React.Component{

    render(){
        return(
            <div className= "App" >
                <h2>menu:</h2>
                <h2>cantidad:</h2> 
                <h2>delivery:</h2>
                <h2>desde:</h2>
                <h2>hasta:</h2>
                <Button variant="primary" onClick ={() => this.GetMenu()}>aceptar</Button>
            </div>
        )
    }

    GetMenu(){
        GetMenu(6).then(res => {
        
            if (res.status === 200){
                console.log("hola")
            }
        })
        .catch((error) => {
            console.log(error)
        });
    }


}

Buy = injectIntl(Buy);

export default Buy;