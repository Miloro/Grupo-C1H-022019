import React from 'react';
import {Icon} from "antd";

function MenuOption({name, icon}) {
    return (
        <span>
            <Icon type={icon}/>
            {name}
        </span>
    );
}

export default MenuOption;