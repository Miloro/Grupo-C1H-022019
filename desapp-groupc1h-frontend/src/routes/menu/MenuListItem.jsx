import React from 'react';
import {Avatar, Button, List, Popover, Rate, Statistic, Tag, Typography} from "antd";
const {Title, Text, Paragraph} = Typography;
const {Item} = List;

function MenuListItem({item}) {

    function CategoryTags({categories}) {
        return categories.map((category) => (
            <Tag key={category} color="#FF8C00">{category}</Tag>
        ))
    }

    function Prices({price, offers}) {
        const content = (
            <div>
                {offers.map((offer, index) => (
                    <p key={index}>{offer.price} {offer.minAmount}</p>
                ))}
            </div>
        );
        return <div>
            <Statistic
                title="Price"
                prefix="$"
                value={price}
                valueStyle={{fontSize: 45}}
            />
            <br/>
            <Popover placement="bottom" content={content} trigger="click">
                <Button>Ofertas!</Button>
            </Popover>
        </div>
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
                <Rate disabled defaultValue={item.reputation} style={{marginRight: 6}}/>,
                <CategoryTags categories={item.categories}/>
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