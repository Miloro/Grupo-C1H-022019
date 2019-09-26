import React from 'react'
import Iframe from 'react-iframe'
export default class MapDev  extends React.Component{

    render(){
        return(
            <div className= "App" >
                <h1>distancia entre dos puntos</h1>
                <h4> sin usar api </h4>
                <Iframe src="https://www.google.com/maps/embed?pb=!1m28!1m12!1m3!1d1639.9317548183894!2d-58.27941080644965!3d-34.70862241304689!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m13!3e3!4m5!1s0x95a331fe293db393%3A0x2a0a79e3ff445dfe!2sUniversidad%20Nacional%20de%20Quilmes%2C%20Roque%20S%C3%A1enz%20Pe%C3%B1a%20352%2C%20B1876%20Bernal%2C%20Buenos%20Aires!3m2!1d-34.706500999999996!2d-58.278529999999996!4m5!1s0x95a32dffde8d53f3%3A0xb77f56d24915083b!2sBernal%2C%20Buenos%20Aires!3m2!1d-34.709440199999996!2d-58.2804213!5e0!3m2!1ses-419!2sar!4v1568082268564!5m2!1ses-419!2sar"
                        width="450px"
                        height="450px"
                        id="myId"
                        className="myClassname"
                        display="initial"
                        position="relative"/>
                <h4> con api </h4>
                <Iframe src="https://image.maps.api.here.com/mia/1.6/routing
?app_id=q2emnCFHJUH5H8xjmBr4
&app_code=NL4Jkc6HKFN_yqpK9aPzMA
&waypoint0=-34.70959,-58.27918
&waypoint1=-34.70632,-58.27728
&lc=1652B4
&lw=6
&t=0
&ppi=320
&w=400
&h=600"
                        width="450px"
                        height="450px"
                        id="myId"
                        className="myClassname"
                        display="initial"
                        position="relative"/>
            </div>
        )
    }
}
