import React from 'react';
import {Avatar, Button, Divider, List, Popover, Rate, Statistic, Table, Tag, Typography} from "antd";
import {useIntl} from "react-intl";
import MenuMap from "./MenuMap";
import { useHistory } from "react-router-dom";
const {Text, Paragraph} = Typography;
const {Item} = List;
const {Column} = Table;

const MenuItem = ({item}) => {
    const {formatMessage} = useIntl();
    let history = useHistory();

    const CategoryTags = ({categories}) => categories.map((category) => (
        <Tag key={category} color="#FF8C00">{category}</Tag>
    ));

    const OffersTable = ({offers}) => {
        const data = offers.map((offer, index) =>(
            {key: index, ...offer}
        ));

        return <Table dataSource={data} size="small" pagination={false}>
            <Column title={formatMessage({id: "price"})} dataIndex="price" key="price" />
            <Column title={formatMessage({id: "minAmount"})} dataIndex="minAmount" key="minAmount"/>
        </Table>;
    };

    const Prices = ({price, offers}) => <div>
        <Statistic
            title={formatMessage({id: "price"})}
            prefix="$"
            value={price}
            valueStyle={{fontSize: 45}}
        />
        <br/>
        <Popover placement="left" content={<OffersTable offers={offers}/>} trigger="click">
            <Button>{formatMessage({id: "offers"})}!</Button>
        </Popover>
    </div>;

    const ServiceInfo = ({serviceLocation, serviceName, serviceScore}) => {
        const location = `${serviceLocation.address}, ${serviceLocation.city}`;
        return <div>
            <span>
                <Text underline>{serviceName}</Text>
                <Divider type="vertical"/>
                <Score score={serviceScore} style={{ fontSize: 15, marginLeft: 6 }}/>
            </span>
            <Paragraph underline>{location}</Paragraph>
        </div>
    };

    const Score = ({score, style}) => {
        return score? <Rate disabled defaultValue={score} style={style}/>:formatMessage({id:"noScore"});
    };

    // noinspection JSUnresolvedVariable,JSUnresolvedVariable
    return (
        <Item
            key={item.id}
            actions={[
                <Score score={item.score} style={{marginRight: 6}}/>,
                <CategoryTags categories={item.categories}/>,
                <MenuMap item={item}/>,
                <Button size="large" type="danger" onClick={() => history.push({
                    pathname: '/buy',
                    state: item
                })}>{formatMessage({id: "buy"})} </Button>,
            ]}
            extra={
                <Prices price={item.price} offers={item.offers}/>
            }
        >
            <Item.Meta
                avatar={<Avatar size={100} src={item.serviceLogo}/>}
                title={<div style={{fontSize: 20}}>{item.name}</div>}
                description={<ServiceInfo serviceLocation={item.serviceLocation} serviceName={item.serviceName}
                                          serviceScore={item.serviceScore}/>}
            />
            {item.description}
        </Item>
    );
};

export default MenuItem;