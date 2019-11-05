import React from 'react'
import { injectIntl} from 'react-intl'
import {Button} from 'react-bootstrap'
import {CreateOrder} from "../api.jsx"

class Buy  extends React.Component{

    render(){
        return(
            <div className= "App" >
                <h2>menu: Menu muy green y sin tacc!</h2>
                <h2>cantidad: 100</h2> 
                <h2>delivery: si</h2>
                <h2>desde: 2019-01-25 21:34:55 </h2>
                <h2>hasta: 2019-01-25 23:34:55</h2>
                <Button variant="primary" onClick ={() => this.confirmOrder()}>aceptar</Button>
            </div>
        )
    }

    confirmOrder(){
        CreateOrder().then(
            res => {
                if (res.status === 200){
                    console.log(res)
                }
            })
            .catch((error) => {
                console.log(error)
            });
    }

}

Buy = injectIntl(Buy);

export default Buy;