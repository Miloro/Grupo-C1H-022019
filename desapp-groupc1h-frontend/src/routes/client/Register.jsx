import React from 'react';
import {Formik} from "formik";
import {Col, Row, Typography, notification} from "antd";
import {Form, Input, InputNumber, SubmitButton} from "formik-antd";
import {FormattedMessage, useIntl} from "react-intl";
import ClientSchema from "./ClientSchema";
import AddressSearcher from "../service/serviceForm/AddressSearcher";
import {useAuth0} from "../../providers/Auth0Provider";
import {post} from "../../api/API";
import {setUserId, useUser} from "../../providers/UserProvider";

const {Title} = Typography;
const {Item} = Form;

const formLayout = {
    wrapperCol: {
        xs: {span: 24},
        sm: {span: 24},
    },
};

const inputNumberProps = {
    style: {width: '100%'}
};

const Register = () => {
    const {formatMessage} = useIntl();
    const {getTokenSilently, user} = useAuth0();
    const [, dispatch] = useUser();

    const initialValues = {
        name: user.given_name,
        lastName: user.family_name,
        email: user.email,
        phoneNumber: undefined,
        query: "",
        selected: {id: undefined, address: undefined},
        location: undefined,
        suggestions: [],
    };

    const onSubmit = (values) => {
        const {query, selected, suggestions, ...client} = values;
        post(getTokenSilently, `/api/client/${user.email}`, client,
            () => {
            dispatch(setUserId(user.email));
            notification.success({
                message: formatMessage({id:"welcomeTo"}),
                description: formatMessage({id:"welcomeMessage"}),
            })})
        };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={ClientSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({values, setFieldValue}) => (
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={20}>
                        <Form {...formLayout}>
                            <Title level={2} className='padding-botton-5 align-left'>
                                <FormattedMessage id="client.create"/>
                            </Title>
                            <Title level={4} className='align-left'>
                                <FormattedMessage id="client.info"/>
                            </Title>
                            <Item name="name">
                                <Input name="name" placeholder={`${formatMessage({id: "name"})}*`}/>
                            </Item>
                            <Item name="lastName">
                                <Input name="lastName" placeholder={formatMessage({id: "lastName"})}/>
                            </Item>
                            <Item name="email">
                                <Input name="email" placeholder="Email*"/>
                            </Item>
                            <Item name="phoneNumber">
                                <InputNumber type="number" name="phoneNumber" {...inputNumberProps}
                                             placeholder={formatMessage({id: "phoneNumber"})}/>
                            </Item>
                            <Title level={4} className='padding-top-4 align-left'>
                                <FormattedMessage id="location"/>*
                            </Title>
                            <AddressSearcher selected={values.selected} suggestions={values.suggestions}
                                             setFieldValue={setFieldValue}/>
                            <Item name="SubmitButton">
                                <SubmitButton size="large">
                                    <FormattedMessage id="create"/>
                                </SubmitButton>
                            </Item>
                        </Form>
                    </Col>
                </Row>
            )}/>
    );
};

export default Register;