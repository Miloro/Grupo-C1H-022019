import React from 'react';
import {Icon, Result} from "antd";

const styleProps = (size)  => ({
    style: {
        fontSize: size,
        color: '#FF8C00'
    }
});

const DefaultResult = ({icon, title, extra}) => (
    <Result
        icon={<Icon type={icon} {...styleProps(50)}/>}
        title={<div {...styleProps(50)}>{title}</div>}
        extra={<div {...styleProps(25)}>{extra}</div>}
        style={{backgroundColor: "#ffffff"}}
    />
);

export default DefaultResult;