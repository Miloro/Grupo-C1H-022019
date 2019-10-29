import React from 'react';
import {Col, Row, Typography} from "antd";
import {Formik} from "formik";
import {Form, SubmitButton} from "@jbuschke/formik-antd";
import ServiceInfoInputs from "./ServiceInfoInputs";
import ServiceShedulePicker from "./ServiceShedulePicker";
import AddressSearcher from "./AddressSearcher";
import axios from "axios";
const {Item} = Form;
const {Title} = Typography;

function ServiceForm({userId}) {
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

    function createTimeTable() {
        const days = ['Monday', 'Tuesday', 'Wednesday',
            'Thursday', 'Friday', 'Saturday', 'Sunday'];
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
                alert(JSON.stringify(location, null, 2));
                const id = 11;
                return axios.post(`/api/user/${id}/service`, values);
            });
    }

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={24}  offset={8}>
                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                    component={ ({ values, setFieldValue }) => (
                        <Form {...formItemLayout}>
                            <Title level={3} className='padding-botton-5'>Crear Servicio</Title>
                            <Title level={4}>Información del Servicio*</Title>
                            <ServiceInfoInputs/>
                            <Title level={4} className='padding-botton-4'>Horario y días de atención*</Title>
                            <ServiceShedulePicker timetable={values.timetable}/>
                            <Title level={4} className='padding-botton-5'>Ubicación*</Title>
                            <AddressSearcher suggestions={values.suggestions} setFieldValue={setFieldValue}/>
                            <Item name="SubmitButton" >
                                <SubmitButton aria-label="Create"/>
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