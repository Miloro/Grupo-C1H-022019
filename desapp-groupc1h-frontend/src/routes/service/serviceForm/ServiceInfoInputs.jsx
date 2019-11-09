import React from 'react';
import {Form, Input, InputNumber} from "formik-antd";
import {useIntl} from "react-intl";
import {Avatar, Col, Row} from "antd";
const {Item} = Form;

function ServiceInfoInputs({logo}) {
    const {formatMessage} = useIntl();
    const inputNumberProps = {
        style: {width: '100%'}
    };

    return (
        <div>
            <Row>
                <Col span={4}>
                    <Avatar size={100} alt="logo" src={logo}/>
                </Col>
                <Col span={20}>
                    <Item name="name">
                        <Input name="name" placeholder={`${formatMessage({id:"name"})}*`}/>
                    </Item>
                    <Item name="logo">
                        <Input name="logo" placeholder="Logo(URL)*"/>
                    </Item>
                </Col>
            </Row>
            <Item name="description">
                <Input.TextArea rows={6} name="description" placeholder={formatMessage({id:"description"})}/>
            </Item>
            <Item name="website">
                <Input name="website" placeholder={formatMessage({id:"website"})}/>
            </Item>
            <Item name="eMail">
                <Input name="eMail" placeholder="Email*"/>
            </Item>
            <Item name="phoneNumber">
                <InputNumber type="number" name="phoneNumber" {...inputNumberProps}
                             placeholder={formatMessage({id:"phoneNumber"})}/>
            </Item>
        </div>
    );
}

export default ServiceInfoInputs;