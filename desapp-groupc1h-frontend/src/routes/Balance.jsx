import React from "react";
import { injectIntl} from "react-intl";
import {Button, Col, InputNumber, Row} from "antd";
import {deposit, withdraw} from "../api.jsx";

class Balance  extends React.Component{
    constructor(props) {
        super(props);
        this.onChangeInputNumberDeposit = this.onChangeInputNumberDeposit.bind(this);
        this.onChangeInputNumberWithdraw = this.onChangeInputNumberWithdraw.bind(this);
        this.state = {amountToDeposit: 0, amountToWithdraw: 0};
        this.alert = React.createRef();

    }

    render(){
        const intl = this.props.intl;
        const withdraw = intl.formatMessage({
            id: "withdraw",
            defaultMessage: "withdraw"
        });
        const deposit = intl.formatMessage({
            id: "deposit",
            defaultMessage: "deposit"
        });
        return(
            <div className= "App" >
                <Row gutter={1} type="flex" justify="center" align="top">

                    <Col span={8}>
                        <h2>{deposit}</h2>
                    </Col>
                    <Col span={8}>
                        <InputNumber defaultValue={0} size={"large"} min={0}
                                     onChange={this.onChangeInputNumberDeposit}/>
                    </Col>
                </Row>
                <Row gutter={1} type="flex" justify="center" align="top">

                    <Col span={8}>
                        <h2>{withdraw}</h2>
                    </Col>
                    <Col span={8}>
                        <InputNumber defaultValue={0} size={"large"} min={0}
                                     onChange={this.onChangeInputNumberWithdraw}/>
                    </Col>
                </Row>
                <Button variant="primary" onClick={() => this.sendNewBalance()}>aceptar</Button>
            </div>
        );
    }

    onChangeInputNumberDeposit(amountToDeposit) {
        this.setState({...this.state, amountToDeposit : amountToDeposit});
    }

    onChangeInputNumberWithdraw(amountToWithdraw) {
        this.setState({...this.state, amountToWithdraw : amountToWithdraw});
    }

    sendNewBalance() {
        deposit(399,this.state.amountToDeposit);
        withdraw(399,this.state.amountToWithdraw);
    }


}

Balance = injectIntl(Balance);

export default Balance;