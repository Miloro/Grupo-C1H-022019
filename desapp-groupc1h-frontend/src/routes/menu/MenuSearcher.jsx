import React from 'react';
import menu from "./mock-menu";
import {List} from "antd";
import MenuOrderRadio from "./MenuOrderRadio";
import MenuListItem from "./MenuListItem";

function MenuSearcher(props) {
    return (
        <List
            itemLayout="vertical"
            bordered={true}
            dataSource={[menu ,menu, menu]}
            header={<MenuOrderRadio/>}
            renderItem={(item) => (<MenuListItem item={item}/>)}
        />
    );
}

export default MenuSearcher;