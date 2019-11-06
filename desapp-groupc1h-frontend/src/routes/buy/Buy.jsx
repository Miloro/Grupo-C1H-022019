import React from 'react'
import { injectIntl} from 'react-intl'
import {Button,InputNumber,Col,Row,Checkbox,DatePicker,TimePicker} from 'antd';
import {CreateOrder} from "../../api.jsx"
import moment from 'moment';
const format = 'HH:mm';

class Buy  extends React.Component{
    constructor(props){
        super(props)
        this.onChangeInputNumber = this.onChangeInputNumber.bind(this)
        this.onChangeCheckBox = this.onChangeCheckBox.bind(this)
        this.onChangeDatePicker = this.onChangeDatePicker.bind(this)
        this.onChangeTimePickerFrom = this.onChangeTimePickerFrom.bind(this)
        this.onChangeTimePickerto = this.onChangeTimePickerto.bind(this)
        this.state = { amount : 0, delivery : false , date : "" ,orderTimeFrom : "00:00" , orderTimeTo : "00:00" }
        this.alert = React.createRef()


    }

    render(){
        return(
            <div className= "App" >
                <Row gutter={1} type="flex" justify="center" align="top">

                        <Col span={8}>
                            <h2>menu:</h2>
                        </Col>
                        <Col span={8}>
                            <h2>Menu muy green y sin tacc!</h2>
                        </Col>
                </Row>                
                
                <Row gutter={1} type="flex" justify="center" align="top">

                        <Col span={8}>
                            <h2>cantidad:</h2>
                        </Col>
                        <Col span={8}>
                            <InputNumber onChange={this.onChangeInputNumber} type="number" justify="center" defaultValue="0" />
                        </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                        <Col span={8}>
                            <h2>delivery:</h2>
                        </Col>
                        <Col span={8}>
                            <Checkbox onChange={this.onChangeCheckBox}/>
                        </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                        <Col span={8}>
                            <h2>dia:</h2>
                        </Col>
                        <Col span={8}>
                            <DatePicker onChange={this.onChangeDatePicker} />
                        </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                        <Col span={8}>
                            <h2>rango:</h2>
                        </Col>
                        <Col span={4}>
                            <TimePicker onChange={this.onChangeTimePickerFrom} defaultValue={moment('00:00', format)} format={format} />
                        </Col>
                        <Col span={4}>
                            <TimePicker onChange={this.onChangeTimePickerto} defaultValue={moment('00:00', format)} format={format} />
                        </Col>
                </Row>
                <Button variant="primary" onClick ={() => this.confirmOrder()}>aceptar</Button>
            </div>
        )
    }

    onChangeInputNumber(amount){
        this.setState({...this.state, amount: amount})
    }

    onChangeCheckBox(isDelivert) {
        this.setState({...this.state, delivery : isDelivert.target.checked})
    }

    onChangeDatePicker(x, dateString) {
        this.setState({...this.state, date : dateString})
    }

    onChangeTimePickerFrom(x,timeFrom){
        this.setState({...this.state, orderTimeFrom : timeFrom})
    }

    onChangeTimePickerto(x,timeTo){
        this.setState({...this.state, orderTimeTo : timeTo})
    }
      

    confirmOrder(){
        CreateOrder(this.state)
    }

}

Buy = injectIntl(Buy);

export default Buy;
