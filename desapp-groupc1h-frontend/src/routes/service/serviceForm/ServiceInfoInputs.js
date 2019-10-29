import React from 'react';
import {Form, Input, InputNumber} from "@jbuschke/formik-antd";
import {useIntl} from "react-intl";
const {Item} = Form;

function ServiceInfoInputs(props) {
    const {formatMessage} = useIntl();

    return (
        <div>
            <Item name="name">
                <Input name="name" placeholder={formatMessage({id:"name"})}/>
            </Item>
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
                <InputNumber className="width-100" type="number" name="phoneNumber" placeholder={formatMessage({id:"phoneNumber"})}/>
            </Item>
        </div>
    );
}

export default ServiceInfoInputs;