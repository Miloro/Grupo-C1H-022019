import React from "react";
import { Form, Input} from "@jbuschke/formik-antd";
import { Formik } from "formik";
import {Button} from "antd";

function ServiceForm(props) {
    const formItemLayout = {
        labelCol: {
            xs: { span: 16 },
            sm: { span: 8 },
        },
        wrapperCol: {
            xs: { span: 16 },
            sm: { span: 8 },
        },
        style: {
            textAlign: "center"
        }
    };
    return (
        <Formik
            initialValues={{ Name: ""}}
            onSubmit={(values, { setSubmitting }) => {
                setTimeout(() => {
                    alert(JSON.stringify(values, null, 2));
                    setSubmitting(false);
                }, 400);
            }}
            render={() => (
                <Form {...formItemLayout}>
                    <Form.Item name="Name">
                    <Input name="Name" placeholder="Name" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">
                            Create
                        </Button>
                </Form>
            )}
        />
    );
}

export default ServiceForm;