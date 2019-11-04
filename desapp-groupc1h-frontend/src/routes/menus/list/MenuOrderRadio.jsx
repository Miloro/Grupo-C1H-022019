import React from 'react';
import {Radio} from "antd";
import {useIntl} from "react-intl";
const {Group} = Radio;

function MenuOrderRadio({onOrderChange, value}) {
    const {formatMessage} = useIntl();

    return (<Group onChange={onOrderChange} name="orders" size="large" value={value}>
            <Radio value={{field: "price", isAsc: true}}>{formatMessage({id: "lowestPrice"})}</Radio>
            <Radio value={{field: "price", isAsc: false}}>{formatMessage({id: "highestPrice"})}</Radio>
            <Radio value={{field: "rating", isAsc: true}}>{formatMessage({id: "lowestRating"})}</Radio>
            <Radio value={{field: "rating", isAsc: false}}>{formatMessage({id: "highestRating"})}</Radio>
        </Group>
    );
}

export default MenuOrderRadio;