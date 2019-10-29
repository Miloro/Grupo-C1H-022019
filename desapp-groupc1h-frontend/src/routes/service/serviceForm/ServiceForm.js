import React from 'react';
import {Col, Row, Typography} from "antd";
import {Formik} from "formik";
import {Form, InputNumber, SubmitButton} from "@jbuschke/formik-antd";
import ServiceInfoInputs from "./ServiceInfoInputs";
import ServiceShedulePicker from "./ServiceShedulePicker";
import AddressSearcher from "./AddressSearcher";
import axios from "axios";
import ServiceSchema from "./ServiceSchema";
import {FormattedMessage, useIntl} from "react-intl";
const {Item} = Form;
const {Title} = Typography;

function ServiceForm({userId}) {
    const {formatMessage} = useIntl();
    const geocoderUrl = 'https://geocoder.api.here.com/6.2/geocode.json';
    const formItemLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 16},
        }
    };

    const initialValues = {
        name: '',
        description: '',
        website: '',
        eMail: '',
        phoneNumber: undefined,
        timetable: createTimeTable(),
        query: '',
        selected: {id: '', address: ''},
        suggestions: [],
        maxDistanceDeliveryInKms: undefined
    };


    function createService(values, location) {
        return {
            name: values.name, description: values.description, website: values.website,
            eMail: values.eMail, phoneNumber: values.phoneNumber, timetable: values.timetable,
            location: location, maxDistanceDeliveryInKms: values.maxDistanceDeliveryInKms
        };
    }


    function createTimeTable() {
        const days = ['monday', 'tuesday', 'wednesday',
            'thursday', 'friday', 'saturday', 'sunday'];
        const createDay = (day) => ({ name: day, checked: false, from: undefined, to: undefined});
        return days.map((day) => createDay(day));
    }

    function createParams(id) {
        return {
            'params': {
                'app_id': 'B3ZYLI1mKHNO6Qt871t6',
                'app_code': 'xibhrih8Kcvp0bcijbEBqA',
                'locationId': id
            }
        };
    }

    function onSubmit(values) {
        axios.get(geocoderUrl,createParams(values.selected.id))
            .then((response) => {
                const checkedLocation = response.data.Response.View[0].Result[0].Location;
                const location = {
                    address:  values.selected.address,
                    coords: {
                        'lat': checkedLocation.DisplayPosition.Latitude,
                        'lon': checkedLocation.DisplayPosition.Longitude
                    }
                };
                const service = createService(values, location);
                alert(JSON.stringify(service, null, 2));
                // return axios.post(`/api/user/${id}/service`, values);
            });
    }

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={24}  offset={8}>
                <Formik
                    initialValues={initialValues}
                    validationSchema={ServiceSchema(formatMessage)}
                    onSubmit={onSubmit}
                    component={ ({values, setFieldValue}) => (
                        <Form {...formItemLayout}>
                            <Title level={3} className='padding-botton-5 align-left'>
                                <FormattedMessage id="service.create"/>
                            </Title>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="service.info"/>
                            </Title>
                            <ServiceInfoInputs/>
                            <Title level={4} className='padding-top-4 align-left'>
                                <FormattedMessage id="service.timetable"/>
                            </Title>
                            <ServiceShedulePicker timetable={values.timetable}/>
                            <Title level={4} className='padding-top-4 align-left'>
                                <FormattedMessage id="service.location"/>
                            </Title>
                            <AddressSearcher suggestions={values.suggestions} setFieldValue={setFieldValue}/>
                            <Item name="maxDistanceDeliveryInKms">
                                <InputNumber className="width-100" type="number" name="maxDistanceDeliveryInKms"
                                       placeholder={formatMessage({id:"service.deliveryDistance"})}/>
                            </Item>
                            <Item name="SubmitButton" >
                                <SubmitButton size="large">
                                    <FormattedMessage id="create"/>
                                </SubmitButton>
                            </Item>
                        </Form>

                    )
                    }
                />
            </Col>
        </Row>
    );

}

export default ServiceForm;