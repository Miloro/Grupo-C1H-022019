import React from 'react'
export default class LogIn  extends React.Component{

    render(){
        return(
            <div className= "App" >
                <h1>buenas</h1>

                <h1 href="#" onclick= {this.props.history.push('/mapdev')}>
                        Click me
                </h1>
            </div>
        )
    }

}