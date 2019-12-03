import React from 'react';
import {Col, Row, Typography, Button, Table} from "antd";
import {Form, Input, InputNumber, Select, DatePicker, SubmitButton} from "formik-antd";
import {Formik} from "formik";
import {FormattedMessage, useIntl} from "react-intl";
import MenuSchema from "./MenuSchema";
import SchedulePicker from "../service/serviceForm/SchedulePicker";
import moment from "moment";
import PriceInput from "./PriceInput";
import {post} from "../../api/API";
import {useAuth0} from "../../providers/Auth0Provider";

const {Item} = Form;
const {Title, Paragraph} = Typography;
const {RangePicker} = DatePicker;
const {Option} = Select;
const {Column} = Table;

const inputNumberProps = {
    style: {width: '100%'}
};

const MenuForm = () => {
        const {formatMessage} = useIntl();
        const {getTokenSilently} = useAuth0();
        const formLayout = {
            wrapperCol: {
                xs: {span: 24},
                sm: {span: 24},
            }
        };

        const timeTable = ['monday', 'tuesday', 'wednesday', 'thursday', 'friday',
            'saturday', 'sunday'].map(day => ({day: day, checked: false, from: null, to: null}));

        const initialValues = {
            name: "",
            description: "",
            categories: [],
            validity: [null, null],
            deliveryInfo: {
                price: null,
                averageTime: null,
                timetable: timeTable
            },
            price: null,
            offers: {
                key: 0,
                price: null,
                minAmount: null,
                ls: []
            },
            maxAmountPerDay: null
        };

        const onSubmit = ({offers, ...menu}) => {
            const menuDTO = {...menu, offers: offers.ls.map(
                offer => {const {key,...offerDTO} = offer; return offerDTO})};
            console.log(JSON.stringify(menuDTO));
            // post(getTokenSilently, "/api/service/{id}/menu", menuDTO, (response) => console.log(response.data));
        };

        const disabledDate = (current) => {
            return current && current < moment().add(2, "days");
        };

        const addOffer = (offers, setFieldValue) => {
            const {ls, ...newOffer} = offers;
            setFieldValue("offers.key", newOffer.key + 1);
            setFieldValue("offers.ls", [...ls, newOffer]);
            setFieldValue("offers.price", null);
            setFieldValue("offers.minAmount", null);
        };

        const deleteOfferButton = (record, ls, setFieldValue) => {
            return <Button type="primary" shape="circle" icon="delete"
                           onClick={() => {
                               const newLs = [...ls];
                               setFieldValue("offers.ls",
                                   newLs.filter(offer => offer.key !== record.key))
                           }}/>;
        };

        return (
            <Formik
                initialValues={initialValues}
                validationSchema={MenuSchema(formatMessage)}
                onSubmit={onSubmit}
                component={({values, setFieldValue}) =>
                    (
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
                                                style={{width: '100%'}}
                                                placeholder={formatMessage({id: "categories"})}>
                                            {["Pizza", "Beer", "Hamburger", "Sushi", "Empanadas",
                                                "Green", "Vegan"].map(category => <Option
                                                key={category}>{category}</Option>)}
                                        </Select>
                                    </Item>
                                    <Title level={4} className='align-left'>
                                        <FormattedMessage id="validityPeriod"/>
                                    </Title>
                                    <Item name="validity">
                                        <RangePicker
                                            name="validity"
                                            showTime={{minuteStep: 30, format: "HH:mm"}}
                                            disabledDate={disabledDate}
                                            format={`${formatMessage({id: "dateFormat"})} HH:mm`}
                                            placeholder={[formatMessage({id: "startDate"}), formatMessage({id: "endDate"})]}
                                        />
                                    </Item>
                                    <Title level={4} className='align-left'>
                                        <FormattedMessage id="delivery"/>
                                    </Title>
                                    <Item name="deliveryInfo.price" label={formatMessage({id: "deliveryPrice"})}>
                                        <PriceInput name="deliveryInfo.price"/>
                                    </Item>
                                    <SchedulePicker timetableName="deliveryInfo.timetable"
                                                    timetable={values.deliveryInfo.timetable}
                                                    setFieldValue={setFieldValue}/>
                                    <Item name="deliveryInfo.averageTime">
                                        <InputNumber type="number" name="deliveryInfo.averageTime" {...inputNumberProps}
                                                     placeholder={formatMessage({id: "averageDeliveryTime"})}/>
                                    </Item>
                                    <Title level={4} className='align-left'>
                                        <FormattedMessage id="price"/>
                                    </Title>
                                    <Item name="price">
                                        <PriceInput name="price"/>
                                    </Item>
                                    <Item name="maxAmountPerDay">
                                        <InputNumber type="number"
                                                     name="maxAmountPerDay"  {...inputNumberProps}
                                                     placeholder={formatMessage({id: "maxAmountPerDay"})}/>
                                    </Item>
                                    <Title level={4} className='align-left'>
                                        <FormattedMessage id="offer"/>
                                    </Title>
                                    <Paragraph>
                                        <FormattedMessage id="offerDisclaimer"/>
                                    </Paragraph>
                                    <Row gutter={[16, 16]}>
                                        <Col span={10}>
                                            <Item name="offers.price">
                                                <PriceInput name="offers.price"/>
                                            </Item>
                                        </Col>
                                        <Col span={10}>
                                            <Item name="offers.minAmount">
                                                <InputNumber type="number"
                                                             name="offers.minAmount" {...inputNumberProps}
                                                             placeholder={formatMessage({id: "minAmount"})}/>
                                            </Item>
                                        </Col>
                                        <Col span={4}>
                                            <Button type="primary" onClick={() => addOffer(values.offers, setFieldValue)}
                                                    disabled={!(values.offers.price && values.offers.minAmount)}>
                                                <FormattedMessage id="add"/>
                                            </Button>
                                        </Col>
                                        <Col span={24}>
                                            <Table dataSource={values.offers.ls} pagination={false}>
                                                <Column title={formatMessage({id: "price"})} dataIndex="price" key="price"/>
                                                <Column title={formatMessage({id: "minAmount"})} dataIndex="minAmount"
                                                        key="minAmount"/>
                                                <Column title={formatMessage({id: "delete"})} dataIndex="delete"
                                                        render={(text, record) => deleteOfferButton(record, values.offers.ls, setFieldValue)}/>
                                            </Table>
                                        </Col>
                                    </Row>
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
    }
;

export default MenuForm;