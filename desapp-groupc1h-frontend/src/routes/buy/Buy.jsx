import React from "react";
import {injectIntl} from "react-intl";
import {Button, InputNumber, Col, Row, Checkbox, DatePicker, TimePicker, notification, Icon} from "antd";
import {createOrder, isNotHoliday} from "../../api.jsx";
import moment from "moment";
import "../../App.css"
import {withRouter} from "react-router-dom";

const format = "HH:mm";

class Buy extends React.Component {

    constructor(props) {
        super(props);
        this.onChangeInputNumber = this.onChangeInputNumber.bind(this);
        this.onChangeCheckBox = this.onChangeCheckBox.bind(this);
        this.onChangeDatePicker = this.onChangeDatePicker.bind(this);
        this.onChangeTimePickerFrom = this.onChangeTimePickerFrom.bind(this);
        this.onChangeTimePickerto = this.onChangeTimePickerto.bind(this);
        this.disabledDate = this.disabledDate.bind(this);
        this.state = {amount: 0, delivery: false, date: "", orderTimeFrom: "00:00", orderTimeTo: "00:00"};
        this.alert = React.createRef();
        console.log( this.props.location)
    }

    render() {
        const {formatMessage} = this.props.intl;
        return (
            <div className="App">
                <Row gutter={1} type="flex" justify="center" align="top">

                    <Col span={8}>
                        <h2>{formatMessage({id:"menu"})}:</h2>
                    </Col>
                    <Col span={8}>
        <h2>{this.props.location.state.name}</h2>
                    </Col>
                </Row>

                <Row gutter={1} type="flex" justify="center" align="top">

                    <Col span={8}>
                        <h2>{formatMessage({id:"amount"})}:</h2>
                    </Col>
                    <Col span={8}>
                        <InputNumber defaultValue={1} size={"large"} min={1} max={100}
                                     onChange={this.onChangeInputNumber}/>
                    </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                    <Col span={8}>
                        <h2>{formatMessage({id:"isDelivery"})}:</h2>
                    </Col>
                    <Col span={8}>
                        <Checkbox onChange={this.onChangeCheckBox}/>
                    </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                    <Col span={8}>
                        <h2>{formatMessage({id:"day"})}:</h2>
                    </Col>
                    <Col span={8}>
                        <DatePicker disabledDate={this.disabledDate} onChange={this.onChangeDatePicker} format={formatMessage({id:"dateFormat"})}/>
                    </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">
                    <Col span={8}>
                        <h2>{formatMessage({id:"hour"})}:</h2>
                    </Col>
                    <Col span={4}>
                        <TimePicker minuteStep={15} onChange={this.onChangeTimePickerFrom}
                                    defaultValue={moment("00:00", format)} format={format}/>
                    </Col>
                    <Col span={4}>
                        <TimePicker minuteStep={15} onChange={this.onChangeTimePickerto}
                                    defaultValue={moment("00:00", format)} format={format}/>
                    </Col>
                </Row>
                <Button variant="primary" onClick={() => this.confirmOrder(formatMessage({id:"successfulOrder"}))}>{formatMessage({id:"toAccept"})}</Button>
            </div>
        );
    }

    onChangeInputNumber(amount) {
        this.setState({...this.state, amount: amount});
    }

    onChangeCheckBox(isDelivert) {
        this.setState({...this.state, delivery: isDelivert.target.checked});
    }

    onChangeDatePicker(x) {
        if (x != null) {
            const date = x._d.toISOString().split('T')[0];
            // noinspection JSUnresolvedVariable,JSUnresolvedVariable
            isNotHoliday(x._d.getDate(), x._d.getMonth(), 2019);
            this.setState({...this.state, date: date});
        }
    }

    onChangeTimePickerFrom(x, timeFrom) {
        this.setState({...this.state, orderTimeFrom: timeFrom});
    }

    onChangeTimePickerto(x, timeTo) {
        this.setState({...this.state, orderTimeTo: timeTo});
    }

    disabledDate(current) {
        // Can not select days before today and today
        return current && current < moment(new Date()).add(2, "days");
    }

    confirmOrder(messageSuccess) {
        // noinspection JSUnresolvedVariable
        createOrder(this.state,this.props.getTokenSilently,this.props.location.state.id, this.props.user.email);
        notification.open({
            message: 'ok',
            description:messageSuccess,
            icon: <Icon type="smile" style={{ color: '#108ee9' }} />,
        });
        this.props.history.push("/")
    }

}

Buy = injectIntl(withRouter(Buy))



export default Buy;
