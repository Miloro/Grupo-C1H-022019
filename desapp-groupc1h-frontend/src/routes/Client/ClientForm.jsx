import React from 'react';
import {Formik} from "formik";
import {Col, Row, Typography} from "antd";
import {Form, Input, InputNumber} from "formik-antd";
import {FormattedMessage, useIntl} from "react-intl";
import ClientSchema from "./ClientSchema";
const {Title} = Typography;
const {Item} = Form;

const formLayout = {
    wrapperCol: {
        xs: {span: 24},
        sm: {span: 24},
    },
};

const inputNumberProps = {
    style: {width: '100%'}
};

const ClientForm = props => {
    const {formatMessage} = useIntl();
    const initialValues = {
        name: "",
        lastName: "",
        email: "",
        phoneNumber: null,
        query: "",
        selected: {id: "", address: ""},
        suggestions: [],
    };

    const onSubmit = () => {

    };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={ClientSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({values, setFieldValue}) => (
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={20}>
                        <Form {...formLayout}>
                            <Title level={2} className='padding-botton-5 align-left'>
                                <FormattedMessage id="client.create"/>
                            </Title>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="client.info"/>
                            </Title>
                            <Item name="name">
                                <Input name="name" placeholder={`${formatMessage({id:"name"})}*`}/>
                            </Item>
                            <Item name="lastName">
                                <Input name="lastName" placeholder={formatMessage({id:"lastName"})}/>
                            </Item>
                            <Item name="email">
                                <Input name="email" placeholder="Email*"/>
                            </Item>
                            <Item name="phoneNumber">
                                <InputNumber type="number" name="phoneNumber" {...inputNumberProps}
                                             placeholder={formatMessage({id:"phoneNumber"})}/>
                            </Item>
                        </Form>
                    </Col>
                </Row>
            )}/>);
};

export default ClientForm;