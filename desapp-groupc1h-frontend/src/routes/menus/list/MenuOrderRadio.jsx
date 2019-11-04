import React from 'react';
import {Radio} from "antd";
import {useIntl} from "react-intl";
const {Group} = Radio;

function MenuOrderRadio({onChange, value}) {
    const {formatMessage} = useIntl();

    return (<Group onChange={onChange} name="orders" size="large" value={value}>
            <Radio value="lowestPrice">{formatMessage({id: "lowestPrice"})}</Radio>
            <Radio value="highestPrice">{formatMessage({id: "highestPrice"})}</Radio>
            <Radio value="lowestRating">{formatMessage({id: "lowestRating"})}</Radio>
            <Radio value="highestRating">{formatMessage({id: "highestRating"})}</Radio>
        </Group>
    );
}

export default MenuOrderRadio;