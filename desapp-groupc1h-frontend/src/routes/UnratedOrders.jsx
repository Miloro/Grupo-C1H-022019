import React, {useEffect, useState} from 'react';
import {Button, Col, Descriptions, List, PageHeader, Rate, Row, Statistic, Typography, message} from "antd";
import {useAPI} from "../providers/ApiProvider";
import {useIntl, FormattedMessage} from "react-intl";

const {Text} = Typography;

const UnratedOrders = () => {
    const [dataSource, setDataSource] = useState([]);
    const {formatMessage} = useIntl();
    const {put, getUnratedOrders} = useAPI();

    useEffect(() => {
        getUnratedOrders(({data}) => {
            setDataSource(data.map(order =>({score:null, ...order})))
        })
    },[]);

    const onRateChange = (value, id) => {
        const newDataSource = dataSource.map(order => {
            if (order.id === id) {
                const {score, ...newOrder} = order;
                return {score: value, ...newOrder}
            }
            return order;
        });
        setDataSource(newDataSource);
    };

    const rateOrder = ({id, name, score}) => {
        put(`/api/order/${id}/score`, score, () => {
            const newDataSource = dataSource.filter(order => order.id !== id);
            setDataSource(newDataSource);
            message.success(formatMessage({id:"successRatingOrder"}, {n:score, takeout:name}));
        });

    };

    // noinspection JSUnresolvedVariable
    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={20} style={{backgroundColor: "#ffffff"}}>
        <List
            style={{padding:8}}
            size="small"
            header={
                <PageHeader
                    title={formatMessage({id: "rateOrders"})}
                    subTitle={formatMessage({id:"rateOrders.subtitle"}, {count: dataSource.length})}
                />}
            itemLayout="horizontal"
            dataSource={dataSource}
            renderItem={item => (
                <List.Item
                    actions={[<Rate value={item.score} onChange={(value => onRateChange(value, item.id))}/>,
                        <Button disabled={!item.score} onClick={() => rateOrder(item)} type="primary">
                            <FormattedMessage id="confirm"/>
                        </Button>
                    ]}
                >
                    <List.Item.Meta
                            title={<Text type="warning">{item.name}</Text>}
                            description={
                                <Descriptions size="small">
                                    <Descriptions.Item label={formatMessage({id: "amount"})}>
                                        {item.amount}
                                    </Descriptions.Item>
                                    <Descriptions.Item label={formatMessage({id: "totalPrice"})}>
                                        <Statistic
                                            prefix="$"
                                            value={item.totalPrice}
                                            valueStyle={{fontSize: 18}}
                                        />
                                    </Descriptions.Item>
                                </Descriptions>
                            }
                        />
                        <div>
                            {`${formatMessage({id:"orderDate"})}: 
                            ${item.orderDate[0].format(formatMessage({id:"orderDateFormat"}))}-
                            ${item.orderDate[1].format(formatMessage({id:"orderDateFormat"}))}`}
                        </div>
                </List.Item>
            )}
        />
            </Col>
        </Row>
    );
};

export default UnratedOrders;