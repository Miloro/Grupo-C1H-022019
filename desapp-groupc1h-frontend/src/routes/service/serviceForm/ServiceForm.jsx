import React from 'react';
import {Col, Modal, Row, Typography} from "antd";
import {Formik} from "formik";
import {Form, InputNumber, SubmitButton} from "formik-antd";
import ServiceInfoInputs from "./ServiceInfoInputs";
import SchedulePicker from "./SchedulePicker";
import AddressSearcher from "./AddressSearcher";
import ServiceSchema from "../ServiceSchema";
import {FormattedMessage, useIntl} from "react-intl";
import {useAuth0} from "../../../providers/Auth0Provider";
import {post} from "../../../api/API";

const {Item} = Form;
const {Title} = Typography;
const {success} = Modal;


const ServiceForm = ({userId, setService}) => {
    const {formatMessage} = useIntl();
    const {getTokenSilently} = useAuth0();
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
        selected: {id: undefined, address: undefined},
        location: undefined,
        suggestions: [],
        maxDistanceDeliveryInKms: undefined
    };

    const convertTimetable = timetable => {
        const converToString = (range) => (range === undefined ? undefined : range.format('HH:mm'));
        return timetable.map((slot) => ({
            day: slot.day.toUpperCase(),
            checked: slot.checked,
            from: converToString(slot.from),
            to: converToString(slot.to),
        }));
    };

    const createService = (values) => ({
        serviceInfo: {
            name: values.name,
            logo: values.logo,
            description: values.description,
            website: values.website,
            eMail: values.eMail,
            phoneNumber: values.phoneNumber
        },
        timetable: convertTimetable(values.timetable),
        location: values.location,
        maxDistanceOfDeliveryInKms: values.maxDistanceDeliveryInKms
    });

    const createdServiceModal = () => {
        const modal = success({
            content: formatMessage({id: "createdService"}),
        });
        setTimeout(() => {
            modal.destroy();
        }, 20 * 1000);
    };

    const onSubmit = values => {
        const service = createService(values);
        post(getTokenSilently, `/api/user/${userId}/service`, service, (response) => {
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
                        <FormattedMessage id="info"/>
                    </Title>
                    <ServiceInfoInputs logo={values.logo}/>
                    <Title level={4} className='padding-top-4 align-left'>
                        <FormattedMessage id="service.timetable"/>
                    </Title>
                    <SchedulePicker timetable={values.timetable} setFieldValue={setFieldValue}/>
                    <Title level={4} className='padding-top-4 align-left'>
                        <FormattedMessage id="location"/>*
                    </Title>
                    <AddressSearcher selected ={values.selected} suggestions={values.suggestions} setFieldValue={setFieldValue}/>
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