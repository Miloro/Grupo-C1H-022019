import React from "react";
import {InputNumber,Form, Input, SubmitButton} from "@jbuschke/formik-antd";
import {Formik} from "formik";
import ServiceSchema from "./ServiceSchema";
import {Col, Row} from "antd";
import axios from 'axios';

function ServiceForm(props) {
    const formItemLayout = {
        wrapperCol: {
            xs: {span: 24},
            sm: {span: 16},
        }
    };
    
    const initialValues = {Name: "", Description: "", WebSite: "", Email: "", PhoneNumber: undefined};
    
    function onSubmit(values, actions) {
        const id= 1;
        setTimeout(() => {
            alert(JSON.stringify(values, null, 2));
            actions.setSubmitting(false);
        }, 400);
        axios.post('/api/user/'+ id, {service: values})
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    function createServiceForm(isSubmitting) {
        return(
        <Form {...formItemLayout}>
            <Form.Item name="Name">
                <Input name="Name" placeholder="Name*"/>
            </Form.Item>
            <Form.Item name="Description">
                <Input.TextArea rows={6} name="Description" placeholder="Description*"/>
            </Form.Item>
            <Form.Item name="WebSite">
                <Input name="WebSite" addonBefore="Http://" addonAfter=".com" placeholder="My Website"/>
            </Form.Item>
            <Form.Item name="Email">
                <Input name="Email" placeholder="Email*"/>
            </Form.Item>
            <Form.Item name="PhoneNumber">
                <Input name="PhoneNumber" placeholder="Phone Number*"/>
            </Form.Item>
            <Form.Item name="SubmitButton">
                <SubmitButton disabled={isSubmitting}>
                    Create
                </SubmitButton>
            </Form.Item>
        </Form>
    );}

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={24}  offset={8}>
                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                    render={createServiceForm}
                    validationSchema={ServiceSchema}
                />
            </Col>
        </Row>
    );
}


export default ServiceForm;