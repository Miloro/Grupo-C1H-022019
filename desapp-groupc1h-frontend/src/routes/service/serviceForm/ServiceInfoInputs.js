import React from 'react';
import {Form, Input, InputNumber} from "@jbuschke/formik-antd";
const {Item} = Form;

function ServiceInfoInputs(props) {
    return (
        <div>
            <Item name="name">
                <Input name="name" placeholder="Name*"/>
            </Item>
            <Item name="description">
                <Input.TextArea rows={6} name="description" placeholder="Description*"/>
            </Item>
            <Item name="website">
                <Input name="website" addonBefore="Http://" addonAfter=".com" placeholder="My Website"/>
            </Item>
            <Item name="eMail">
                <Input name="eMail" placeholder="Email*"/>
            </Item>
            <Item name="phoneNumber">
                <InputNumber className="width-100" type="number" name="phoneNumber" placeholder="Phone Number*"/>
            </Item>
        </div>
    );
}

export default ServiceInfoInputs;