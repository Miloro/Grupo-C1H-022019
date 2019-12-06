import React from 'react';
import {Avatar, Button, List, Popover, Rate, Statistic, Table, Tag, Typography} from "antd";
import {useIntl} from "react-intl";
import MenuMap from "./MenuMap";
import { useHistory } from "react-router-dom";
const {Text, Paragraph} = Typography;
const {Item} = List;
const {Column} = Table;

function MenuItem({item}) {
    const {formatMessage} = useIntl();
    let history = useHistory();
    function CategoryTags({categories}) {
        return categories.map((category) => (
            <Tag key={category} color="#FF8C00">{category}</Tag>
        ))


    }


    function Prices({price, offers}) {
        return <div>
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
        </div>
    }

    function OffersTable({offers}) {
        const data = offers.map((offer, index) =>(
            {key: index, ...offer}
        ));

        return <Table dataSource={data} size="small" pagination={false}>
            <Column title={formatMessage({id: "price"})} dataIndex="price" key="price" />
            <Column title={formatMessage({id: "minAmount"})} dataIndex="minAmount" key="minAmount"/>
        </Table>;
    }

    function Location({serviceLocation, serviceName}) {
        const location = `${serviceLocation.address}, ${serviceLocation.city}`;
        return <div>
            <span>
                <Text underline>{serviceName}</Text>
            <Rate disabled defaultValue={2} style={{ fontSize: 15, marginLeft: 6 }}/>
            </span>
            <Paragraph underline>{location}</Paragraph>
        </div>
    }


    // noinspection JSUnresolvedVariable,JSUnresolvedVariable
    return (
        <Item
            key={item.id}
            actions={[
                <Rate disabled defaultValue={item.score} style={{marginRight: 6}}/>,
                <CategoryTags categories={item.categories}/>,
                <MenuMap item={item}/>,
                <Button size="large" type="danger" onClick={() => history.push("/buy",item)}>{formatMessage({id: "buy"})} </Button>,
            ]}
            extra={
                <Prices price={item.price} offers={item.offers}/>
            }
        >
            <Item.Meta
                avatar={<Avatar size={100} src={item.serviceLogo}/>}
                title={<div style={{fontSize: 20}}>{item.name}</div>}
                description={<Location serviceLocation={item.serviceLocation} serviceName={item.serviceName}/>}
            />
            {item.description}
        </Item>
    );
}

export default MenuItem;