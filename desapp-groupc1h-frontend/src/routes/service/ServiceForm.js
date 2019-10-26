import React from "react";
import {Form, Input, SubmitButton} from "@jbuschke/formik-antd";
import {ErrorMessage, Formik} from "formik";
import ServiceSchema from "./ServiceSchema";
import {Col, Row} from "antd";
import axios from 'axios';
import {useIntl} from "react-intl";
import es from "./es";
import en from "./en";

function ServiceForm() {
    const {formatMessage, locale} = useIntl();
    const formItemLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 16},
        }
    };
    
    const initialValues = {name: "", description: "", website: "", eMail: "", phoneNumber: undefined};

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

    function createServiceForm(isSubmitting, errors) {
        return(
        <Form {...formItemLayout}>
            {formatMessage({id:'min'}, {min: 2})}
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
                <Input name="phoneNumber" placeholder="Phone Number*"/>
            </Form.Item>
            {/*<Form.Item name="timetable-day">*/}
            {/*    <Radio name="timetable"> Monday </Radio>*/}
            {/*</Form.Item>*/}
            {/* <Form.Item name="timetable-hourRange">*/}
            {/*    <DatePicker.RangePicker*/}
            {/*        name="timetable-hourRange"*/}
            {/*        mode={['time','time']}*/}
            {/*        showTime*/}
            {/*        format="YYYY"*/}
            {/*    />*/}
            {/*</Form.Item>*/}
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
                    render={createServiceForm}
                    validationSchema={ServiceSchema(getCurrentLocaleDict())}
                />
            </Col>
        </Row>
    );
}


export default ServiceForm;