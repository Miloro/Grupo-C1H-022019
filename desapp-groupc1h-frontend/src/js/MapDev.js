import React from 'react'
import Iframe from 'react-iframe'
export default class MapDev  extends React.Component {

    render() {
        return (
            <div className="App">
                <h1>distancia entre dos puntos</h1>
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
