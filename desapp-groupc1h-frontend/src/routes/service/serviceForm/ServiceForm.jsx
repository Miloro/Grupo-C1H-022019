import React from 'react';
import {Col, Modal, Row, Typography} from "antd";
import {Formik} from "formik";
import {Form, InputNumber, SubmitButton} from "formik-antd";
import ServiceInfoInputs from "./ServiceInfoInputs";
import ServiceShedulePicker from "./ServiceShedulePicker";
import AddressSearcher from "./AddressSearcher";
import axios from "axios";
import ServiceSchema from "../ServiceSchema";
import {FormattedMessage, useIntl} from "react-intl";

const {Item} = Form;
const {Title} = Typography;
const {success} = Modal;


const ServiceForm = ({userId, setService}) => {
    const {formatMessage} = useIntl();
    const geocoderUrl = 'https://geocoder.api.here.com/6.2/geocode.json';
    const formLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 24},
        },
    };
    const inputNumberProps = {
        style: {width: '100%'}
    };

    const initialTimeTable = () => {
        const days = ['monday', 'tuesday', 'wednesday',
            'thursday', 'friday', 'saturday', 'sunday'];
        const createDay = (day) => ({day: day, checked: false, from: undefined, to: undefined});
        return days.map((day) => createDay(day));
    };

    const initialValues = {
        name: '',
        logo: '',
        description: '',
        website: '',
        eMail: '',
        phoneNumber: undefined,
        timetable: initialTimeTable(),
        query: '',
        selected: {id: '', address: ''},
        suggestions: [],
        maxDistanceDeliveryInKms: undefined
    };

    const hereMapsParams = id => ({
        'params': {
            'app_id': 'B3ZYLI1mKHNO6Qt871t6',
            'app_code': 'xibhrih8Kcvp0bcijbEBqA',
            'locationId': id
        }
    });

    const convertTimetable = timetable => {
        const converToString = (range) => (range === undefined ? undefined : range.format('HH:mm'));
        return timetable.map((slot) => ({
            day: slot.day.toUpperCase(),
            checked: slot.checked,
            from: converToString(slot.from),
            to: converToString(slot.to),
        }));
    };

    const createService = (values, location) => ({
        serviceInfo: {
            name: values.name,
            logo: values.logo,
            description: values.description,
            website: values.website,
            eMail: values.eMail,
            phoneNumber: values.phoneNumber
        },
        timetable: convertTimetable(values.timetable),
        location: location,
        maxDistanceOfDeliveryInKms: values.maxDistanceDeliveryInKms
    });

    const createLocation = response => {
        const location = response.data.Response.View[0].Result[0].Location;
        return {
            address: `${location.Address.Street} ${location.Address.HouseNumber}`,
            city: `${location.Address.City}`,
            latitude: location.DisplayPosition.Latitude,
            longitude: location.DisplayPosition.Longitude
        };
    };

    const createdServiceModal = () => {
        const modal = success({
            content: formatMessage({id: "createdService"}),
        });
        setTimeout(() => {
            modal.destroy();
        }, 20 * 1000);
    };

    const onSubmit = values => {
        let service;
        axios.get(geocoderUrl, hereMapsParams(values.selected.id))
            .then((response) => {
                const location = createLocation(response);
                service = createService(values, location);
                return axios.post(`/api/user/${userId}/service`, service);
            }).then((response) => {
            service.id = response.data;
            setService(service);
            createdServiceModal();
        });
    };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={ServiceSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({values, setFieldValue}) => (
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={20}>
                <Form {...formLayout}>
                    <Title level={2} className='padding-botton-5 align-left'>
                        <FormattedMessage id="service.create"/>
                    </Title>
                    <Title level={4} className='align-left'>
                        <FormattedMessage id="service.info"/>
                    </Title>
                    <ServiceInfoInputs logo={values.logo}/>
                    <Title level={4} className='padding-top-4 align-left'>
                        <FormattedMessage id="service.timetable"/>
                    </Title>
                    <ServiceShedulePicker timetable={values.timetable} setFieldValue={setFieldValue}/>
                    <Title level={4} className='padding-top-4 align-left'>
                        <FormattedMessage id="location"/>*
                    </Title>
                    <AddressSearcher suggestions={values.suggestions} setFieldValue={setFieldValue}/>
                    <Item name="maxDistanceDeliveryInKms">
                        <InputNumber type="number" name="maxDistanceDeliveryInKms" {...inputNumberProps}
                                     placeholder={formatMessage({id: "service.deliveryDistance"})}/>
                    </Item>
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

export default ServiceForm;