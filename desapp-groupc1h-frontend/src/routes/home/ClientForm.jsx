import React from 'react';
import {Formik} from "formik";
import {Col, Row, Typography} from "antd";
import {Form, Input, InputNumber, SubmitButton} from "formik-antd";
import {FormattedMessage, useIntl} from "react-intl";
import ClientSchema from "./ClientSchema";
import AddressSearcher from "../service/serviceForm/AddressSearcher";
import {useAuth0} from "../../providers/Auth0Provider";
import {useAPI} from "../../providers/ApiProvider";
import {useUser} from "../../providers/UserProvider";

const {Title, Paragraph} = Typography;
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

const ClientForm = () => {
    const {formatMessage} = useIntl();
    const {user} = useAuth0();
    const {postClient} = useAPI();
    const {setClientId} = useUser();

    const initialValues = {
        name: user.given_name,
        lastName: user.family_name,
        email: user.email,
        phoneNumber: null,
        query: "",
        selected: {id: null, address: null},
        location: null,
        suggestions: [],
    };

    const onSubmit = (values) => {
        const {query, selected, suggestions, ...client} = values;
        postClient(client, (response) => {
            setClientId(response.data);
        });
    };

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={ClientSchema(formatMessage)}
            onSubmit={onSubmit}
            component={({values, setFieldValue}) => (
                <Row type="flex" justify="space-around" align="middle" style={{backgroundColor: "#ffffff"}}>
                    <Col span={20}>
                        <Form {...formLayout}>
                            <Title level={2} className='align-left'>
                                <FormattedMessage id="client.create"/>
                            </Title>
                            <Paragraph><FormattedMessage id="client.create.description"/></Paragraph>
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

export default ClientForm;