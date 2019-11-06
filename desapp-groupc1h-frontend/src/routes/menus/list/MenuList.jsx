import React from 'react';
import MenuListItem from "./MenuListItem";
import {List} from "antd";

function MenuList({dataSource, isLoading}) {

    return (
        <List
            itemLayout="vertical"
            bordered={true}
            dataSource={dataSource}
            renderItem={(item) => (<MenuListItem item={item}/>)}
            loading={isLoading}
            style={{minHeight: "400px"}}
        />
    );
}

export default MenuList;