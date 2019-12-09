import React from 'react';

import {useUser} from "../../providers/UserProvider";
import {useIntl} from "react-intl";
import {getOrdersUser} from "../../api.jsx";
import {useAuth0} from "../../providers/Auth0Provider";
import { Card, Col, Row } from 'antd';

const Orders= () => {
    const {formatMessage} = useIntl();
    const {clientId} = useUser();
    const {getTokenSilently} = useAuth0();


const ordenes = getOrders(clientId,getTokenSilently).then(res => {return res});

const ordenestest = [{"id":19,"amount":1,"menuName":"Menu muy green y sin tacc!","orderDate":["2019-12-02T14:35:54.877","2019-12-02T15:35:54.877"],"totalPrice":399.99}
                    ,{"id":21,"amount":33,"menuName":"Pizza especial con jamon, muzarrella y morron","orderDate":["2019-11-18T19:35:54.877","2019-11-18T20:35:54.878"],"totalPrice":6719.80}
                    ,{"id":18,"amount":11,"menuName":"Menu muy green y sin tacc!","orderDate":["2019-12-02T14:35:54.877","2019-12-02T15:35:54.877"],"totalPrice":4399.89}
                    ,{"id":22,"amount":21,"menuName":"Pizza especial con jamon, muzarrella y morron","orderDate":["2019-11-29T14:35:54.878","2019-11-18T15:35:54.878"],"totalPrice":4244.10}]

    const listItems = ordenestest.map((order) =>
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
}

function getOrders(clientId,tokenSilently){
   return getOrdersUser(clientId,tokenSilently);
}


export default Orders;