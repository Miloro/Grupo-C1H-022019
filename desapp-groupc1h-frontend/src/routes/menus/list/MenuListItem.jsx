import React from 'react';
import {Avatar, Button, List, Popover, Rate, Statistic, Table, Tag, Typography} from "antd";
import {useIntl} from "react-intl";
const {Title, Text, Paragraph} = Typography;
const {Item} = List;
const {Column} = Table;

function MenuListItem({item}) {
    const {formatMessage} = useIntl();

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

    function Location({service}) {
        const location = `${service.location.address}, ${service.location.city}`;
        return <div>
            <span>
                <Text underline>{service.name}</Text>
            <Rate disabled defaultValue={2} style={{ fontSize: 15, marginLeft: 6 }}/>
            </span>
            <Paragraph underline>{location}</Paragraph>
        </div>
    }


    return (
        <Item
            key={item.id}
            actions={[
                <Rate disabled defaultValue={item.score} style={{marginRight: 6}}/>,
                <CategoryTags categories={item.categories}/>,
                <Button size="large"  style={{marginLeft: 15}}>{formatMessage({id: "view"})}</Button>,
                <Button size="large" type="danger">{formatMessage({id: "buy"})}</Button>,
            ]}
            extra={
                <Prices price={item.price} offers={item.offers}/>
            }
        >
            <Item.Meta
                avatar={<Avatar size={100} src={item.service.logo}/>}
                title={<Title level={4}>{item.name}</Title>}
                description={<Location service={item.service}/>}
            />
            {item.description}
        </Item>
    );
}

export default MenuListItem;