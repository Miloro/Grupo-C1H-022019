import React from 'react';
import {Col, Row, Typography} from "antd";
import {Form, Input, InputNumber, Select, DatePicker, SubmitButton} from "formik-antd";
import {Formik} from "formik";
import {FormattedMessage, useIntl} from "react-intl";
import MenuSchema from "./MenuSchema";
import SchedulePicker from "../service/serviceForm/SchedulePicker";

const {Item} = Form;
const {Title} = Typography;
const {RangePicker} = DatePicker;

const inputNumberProps = {
    style: {width: '100%'}
};

function MenuForm() {
    const {formatMessage} = useIntl();
    const formLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 24},
        },
    };

    const initialValues = {};

    const onSubmit = () => {

    };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={MenuSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({isSubmitting}) => (
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={20}>
                        <Form {...formLayout}>
                            <Title level={2} className='padding-botton-5 align-left'>
                                <FormattedMessage id="menu.create"/>
                            </Title>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="info"/>
                            </Title>
                            <Item name="name">
                                <Input name="name" placeholder={`${formatMessage({id: "name"})}*`}/>
                            </Item>
                            <Item name="description">
                                <Input.TextArea rows={6} name="description"
                                                placeholder={formatMessage({id: "description"})}/>
                            </Item>
                            <Item name="categories">
                                <Select name="categories" mode="multiple" style={{ width: '100%' }}
                                        placeholder={formatMessage({id: "menu.select.categories"})}
                                />
                            </Item>
                            <Item name="validity">
                                <RangePicker
                                    name="validity"
                                    showTime
                                    format="YYYY/MM/DD HH:mm:ss"
                                />
                            </Item>
                            <SchedulePicker/>
                            <Item name="deliveryPrice">
                                <InputNumber type="number" name="deliveryPrice" {...inputNumberProps}
                                             formatter={value => `$ ${value}`.replace(/\B(?=(\d{3})+(?!\d))/g, ',')}
                                             parser={value => value.replace(/\$\s?|(,*)/g, '')}
                                             placeholder={formatMessage({id:"menu.deliveryPrice"})}/>
                            </Item>
                            <Item name="averageDeliveryTime">
                                <InputNumber type="number" name="averageDeliveryTime" {...inputNumberProps}
                                                 placeholder={formatMessage({id:"menu.averageDeliveryTime"})}/>
                            </Item>
                            <Item name="SubmitButton">
                                <SubmitButton size="large" disabled={isSubmitting}>
                                    <FormattedMessage id="create"/>
                                </SubmitButton>
                            </Item>
                        </Form>
                    </Col>
                </Row>
            )}
        />
    );
}

export default MenuForm;