import React from "react";
import {useIntl} from "react-intl";
import {Button, Col, InputNumber, Row,  notification, Icon} from "antd";
import {deposit, withdraw} from "../api.jsx";
import {useAuth0} from "../providers/Auth0Provider";
import {useHistory} from "react-router-dom";


const Balance= () => {
    const {formatMessage} = useIntl();
    const {getTokenSilently, user} = useAuth0();
    let history = useHistory();
    var dep = 0;
    var wit = 0;

    return (
        <div className= "App" >
            <Row gutter={1} type="flex" justify="center" align="top">

                <Col span={8}>
                    <h2>{formatMessage({id: "deposit"})}</h2>
                </Col>
                <Col span={8}>
                    <InputNumber defaultValue={0} size={"large"} min={0}
                                 onChange={monto => {dep = monto}}/>
                </Col>
            </Row>
            <Row gutter={1} type="flex" justify="center" align="top">

                <Col span={8}>
                    <h2>{formatMessage({id: "withdraw"})}</h2>
                </Col>
                <Col span={8}>
                    <InputNumber defaultValue={0} size={"large"} min={0}
                                 onChange={monto => {wit = monto}}/>
                </Col>
            </Row>
            <Button variant="primary" onClick={() => sendNewBalance(user.email, dep, wit, getTokenSilently, history,formatMessage)} > {formatMessage({id:"toAccept"})}  </Button>
        </div>
    );
};

function sendNewBalance(emailUser, amountDeposit, amountWithdraw, token, history,formatMessage) {
    deposit(emailUser, amountDeposit, token);
    withdraw(emailUser, amountWithdraw, token);
    notification.open({
        message: 'ok',
        description:formatMessage({id:"successful"}),
        icon: <Icon type="smile" style={{ color: '#108ee9' }} />,
    });
    history.push("/")
}

export default Balance;