import React from "react";
import {Form, Input, InputNumber, SubmitButton, Checkbox, TimePicker} from "@jbuschke/formik-antd";
import {ErrorMessage, Formik} from "formik";
import ServiceSchema from "./ServiceSchema";
import {Col, Row} from "antd";
import { Typography } from 'antd';
import axios from 'axios';
import {useIntl} from "react-intl";
import es from "./es";
import en from "./en";
const { Title } = Typography;

function ServiceForm() {
    const {locale} = useIntl();
    const format = 'HH:mm';
    const formItemLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 16},
        }
    };

    const initialValues = {name: "", description: "",
        website: "", eMail: "",
        phoneNumber: undefined,
        timetable: createTimeTable()
    };

    function createTimeTable() {
        const days = ['Monday', 'Tuesday', 'Wednesday',
            'Thursday', 'Friday', 'Saturday', 'Sunday'];
        const createDay = (day) => ({ name: day, checked: false, from: undefined, to: undefined});
        return days.map((day) => createDay(day));
    }

    function onSubmit(values, actions) {
        const id= 11;
        setTimeout(() => {
            alert(JSON.stringify(values, null, 2));
            actions.setSubmitting(false);
        }, 400);
        axios.post(`/api/user/${id}/service`, values)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }


    function createTimetableComponent(timetable) {
        return (
        timetable.map((slot, index) =>
                <Row key={slot.name}>
                    <Col span={6}>
                        <Form.Item name={`timetable[${index}].checked`}>
                            <Checkbox name={`timetable[${index}].checked`}> {slot.name}</Checkbox>
                        </Form.Item>
                    </Col>
                    <Col span={4}>
                        <Form.Item name={`timetable[${index}].from`}>
                            <TimePicker name={`timetable[${index}].from`} format={format} disabled={!slot.checked}/>
                        </Form.Item>
                    </Col>
                    <Col span={4}>
                        <Form.Item name={`timetable[${index}].to`}>
                            <TimePicker name={`timetable[${index}].to`} format={format} disabled={!slot.checked}/>
                        </Form.Item>
                    </Col>
                </Row>
            )
        );
    }

    function createServiceForm(props) {
        const {isSubmitting, values} = props;
        return(
        <Form {...formItemLayout}>
            <Title level={3} style={{ textAlign: 'left', paddingBottom: '5%' }}>Crear Servicio</Title>
            <Form.Item name="name">
                <Input name="name" placeholder="Name*"/>
            </Form.Item>
            <Form.Item name="description">
                <Input.TextArea rows={6} name="description" placeholder="Description*"/>
            </Form.Item>
            <Form.Item name="website">
                <Input name="website" addonBefore="Http://" addonAfter=".com" placeholder="My Website"/>
            </Form.Item>
            <Form.Item name="eMail">
                <Input name="eMail" placeholder="Email*"/>
                <ErrorMessage name="eMail" />
            </Form.Item>
            <Form.Item name="phoneNumber">
                <InputNumber type="number" name="phoneNumber" placeholder="Phone Number*" style={{ width: '100%' }} />
            </Form.Item>
            <Title level={4} style={{ textAlign: 'left', paddingTop: '4%' }}>Horario y días de atención*</Title>
            {createTimetableComponent(values.timetable)}
            <Title level={4} style={{ textAlign: 'left', paddingTop: '4%' }}>Ubicacion</Title>
            <Row>
                <Col span={8}>
            <Form.Item name="location.adress">
                <Input name="location.adress" placeholder="Adress*"/>
            </Form.Item>
                </Col>
            <Col span={8}>
            <Form.Item name="location.city">
                <Input name="location.city" placeholder="City*"/>
            </Form.Item>
        </Col>
            </Row>
            <Form.Item name="SubmitButton">
                <SubmitButton disabled={isSubmitting}>
                    Create
                </SubmitButton>
            </Form.Item>
        </Form>
    );}

    function getCurrentLocaleDict() {
        return locale === 'es'? es: en;
    }

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={24}  offset={8}>
                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                    validationSchema={ServiceSchema(getCurrentLocaleDict())}
                >
                    {props => (createServiceForm(props))}

                </Formik>
            </Col>
        </Row>
    );
}


export default ServiceForm;