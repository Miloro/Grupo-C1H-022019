import React ,{useEffect,useState} from 'react';

import {useUser} from "../../providers/UserProvider";
import {useIntl} from "react-intl";
import {getOrdersUser} from "../../api.jsx";
import {useAuth0} from "../../providers/Auth0Provider";
import { Card, Col, Row } from 'antd';

const Orders= () => {
    const {formatMessage} = useIntl();
    const {clientId} = useUser();
    const {getTokenSilently} = useAuth0();
    const [order, setOrder] = useState([]);

    useEffect(() => {
            getOrdersUser(clientId, getTokenSilently,setOrder);
        },
        [clientId, getTokenSilently]);

    const listItems = order.map((order) =>
        <Col>
            <Card title={order.menuName} >
                <p>{formatMessage({id:"amount"})} = {order.amount}</p>
                <p>{formatMessage({id:"totalPrice"})} = ${order.totalPrice}</p>
            </Card>
        </Col>
    );

    return (
        <div style={{ background: '#ECECEC', padding: '30px' }}>
            <Row gutter={20}>
                {listItems}
            </Row>
        </div>
    );
};

export default Orders;