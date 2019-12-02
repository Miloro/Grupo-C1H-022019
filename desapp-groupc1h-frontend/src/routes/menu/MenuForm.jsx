import React from 'react';
import {Col, Row, Typography, Input as InputAntd, Button} from "antd";
import {Form, Input, InputNumber, Select, DatePicker, SubmitButton} from "formik-antd";
import {Formik} from "formik";
import {FormattedMessage, useIntl} from "react-intl";
import MenuSchema from "./MenuSchema";
import SchedulePicker from "../service/serviceForm/SchedulePicker";
import moment from "moment";
import PriceInput from "./PriceInput";

const {Item} = Form;
const {Title} = Typography;
const {RangePicker} = DatePicker;
const {Option} = Select;
const {Group} = InputAntd;

const inputNumberProps = {
    style: {width: '100%'}
};

const MenuForm = () => {
    const {formatMessage} = useIntl();
    const formLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 24},
        },
    };

    const timeTable = ['monday', 'tuesday', 'wednesday', 'thursday', 'friday',
        'saturday', 'sunday'].map(day => ({day: day, checked: false, from: null, to: null}));

    const initialValues = {
        name: "",
        description: "",
        categories: [],
        validity: [null,null],
        deliveryInfo: {
            price: null,
            averageTime: null,
            timetable: timeTable
        },
        prices: {
            price: null,
            offers:{
                price: null,
                minAmount: null,
                list:[{price:null, minAmount: null},
                {price:null, minAmount: null}]
            }
        }
    };

    const onSubmit = (values) => {
        console.log(values);
    };

    const disabledDate = (current) => {
        return current && current < moment().add(2, "days");
    };

    const addOffer = (values) => {
    };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={MenuSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({values, setFieldValue, isSubmitting,isValid}) => (
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
                                <Select name="categories"
                                        mode="multiple"
                                        style={{ width: '100%' }}
                                        placeholder={formatMessage({id: "categories"})}>
                                    {["Pizza", "Beer", "Hamburger", "Sushi", "Empanadas",
                                        "Green", "Vegan"].map(category => <Option key={category}>{category}</Option>)}
                                </Select>
                            </Item>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="validityPeriod"/>
                            </Title>
                            <Item name="validity">
                                <RangePicker
                                    name="validity"
                                    showTime={{minuteStep:30, format:"HH:mm"}}
                                    disabledDate={disabledDate}
                                    format={`${formatMessage({id: "dateFormat"})} HH:mm`}
                                    placeholder={[formatMessage({id: "startDate"}), formatMessage({id: "endDate"})]}
                                />
                            </Item>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="delivery"/>
                            </Title>
                            <Item name="deliveryInfo.price" label={formatMessage({id:"deliveryPrice"})}>
                                <PriceInput name="deliveryInfo.price"/>
                            </Item>
                            <SchedulePicker timetableName="deliveryInfo.timetable"
                                            timetable={values.deliveryInfo.timetable}
                                            setFieldValue={setFieldValue}/>
                            <Item name="deliveryInfo.averageTime">
                                <InputNumber type="number" name="deliveryInfo.averageTime" {...inputNumberProps}
                                                 placeholder={formatMessage({id:"averageDeliveryTime"})}/>
                            </Item>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="price"/>
                            </Title>
                            <Item name="prices.price" label={formatMessage({id:"price"})}>
                                <PriceInput name="prices.price"/>
                            </Item>
                            <Group>
                                <Item name="prices.offers.price" label={formatMessage({id:"price"})}>
                                    <PriceInput name="prices.offers.price"/>
                                </Item>
                                <Item name="prices.offers.minAmount">
                                <InputNumber type="number" name="prices.offers.minAmount" {...inputNumberProps}
                                             placeholder={formatMessage({id:"minAmount"})}/>
                                </Item>
                                <Button onChange={() => addOffer(values)}>
                                    <FormattedMessage id="add"/>
                                </Button>
                            </Group>

                            <Item name="SubmitButton">
                                <SubmitButton size="large">
                                    <FormattedMessage id="create"/>
                                </SubmitButton>
                            </Item>
                        </Form>
                    </Col>
                </Row>
            )}
        />
    );
};

export default MenuForm;