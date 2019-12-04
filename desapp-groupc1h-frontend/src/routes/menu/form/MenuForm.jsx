import React from 'react';
import {Col, Row, Typography, Button, message as notification, Modal} from "antd";
import {Form, Input, Select, DatePicker, SubmitButton} from "formik-antd";
import {Formik} from "formik";
import {FormattedMessage, useIntl} from "react-intl";
import MenuSchema from "../MenuSchema";
import moment from "moment";
import PriceInput from "./PriceInput";
import {post} from "../../../api/API";
import {useAuth0} from "../../../providers/Auth0Provider";
import {useHistory} from "react-router-dom";
import {useUser} from "../../../providers/UserProvider";
import OffersTable from "./OffersTable";
import NumberInput from "../../../components/NumberInput";
import DeliveryInfoInputs from "./DeliveryInfoInputs";

const {Item} = Form;
const {Title} = Typography;
const {RangePicker} = DatePicker;
const {Option} = Select;
const {success} = Modal;

const MenuForm = () => {
        const {formatMessage} = useIntl();
        const {getTokenSilently} = useAuth0();
        let history = useHistory();
        const [{serviceId},] = useUser();
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
            cookingTime: null,
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

        const onSubmit = ({offers, ...menu}, {setSubmitting}) => {
            const menuDTO = {
                ...menu, offers: offers.ls.map(offer => {const {key, ...offerDTO} = offer;return offerDTO})};
            console.log(JSON.stringify(menuDTO));
            post(getTokenSilently, `/api/service/${serviceId}/menu`, menuDTO,
                () => {
                    history.push("/menus/search");
                    const modal = success({
                        content: formatMessage({id: "createdMenu"}),
                    });
                    setTimeout(() => {
                        modal.destroy();
                    }, 20 * 1000);
                },
                (apiError) => {
                    try {
                        setSubmitting(false);
                        const {status, error, message} = apiError.response.data;
                        const apiErrorMessage = `Status ${status} ${error}: ${formatMessage({id: message})}`;
                        notification.error(apiErrorMessage);
                    } catch (error1) {
                        console.log(error1)
                    }
                }
            );
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
                                    <Item name="cookingTime">
                                        <NumberInput name="cookingTime"
                                                     placeholder={formatMessage({id: "cookingTime"})}/>
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
                                    <DeliveryInfoInputs setFieldValue={setFieldValue}
                                                        timetable={values.deliveryInfo.timetable}/>
                                    <Title level={4} className='align-left'>
                                        <FormattedMessage id="price"/>
                                    </Title>
                                    <Item name="price">
                                        <PriceInput name="price"/>
                                    </Item>
                                    <Item name="maxAmountPerDay">
                                        <NumberInput name="maxAmountPerDay"
                                                     placeholder={formatMessage({id: "maxAmountPerDay"})}/>
                                    </Item>
                                    <OffersTable offers={values.offers}
                                                 addOffer={() => addOffer(values.offers, setFieldValue)}
                                                 deleteOfferButton={(text, record) => deleteOfferButton(record, values.offers.ls, setFieldValue)}
                                    />
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