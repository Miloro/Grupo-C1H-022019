import React from 'react';
import {FormattedMessage, useIntl} from "react-intl";
import PriceInput from "./PriceInput";
import SchedulePicker from "../../service/serviceForm/SchedulePicker";
import {Form, InputNumber} from "formik-antd";
import {Typography} from "antd";
import NumberInput from "../../../components/NumberInput";

const {Item} = Form;
const {Title} = Typography;

function DeliveryInfoInputs({timetable, setFieldValue}) {
    const {formatMessage} = useIntl();

    return (
        <div>
            <Title level={4} className='align-left'>
                <FormattedMessage id="delivery"/>
            </Title>
            <Item name="deliveryInfo.price" label={formatMessage({id: "deliveryPrice"})}>
                <PriceInput name="deliveryInfo.price"/>
            </Item>
            <SchedulePicker timetableName="deliveryInfo.timetable"
                            timetable={timetable}
                            setFieldValue={setFieldValue}/>
            <Item name="deliveryInfo.averageTime">
                <NumberInput name="deliveryInfo.averageTime" placeholder={formatMessage({id: "averageDeliveryTime"})}/>
            </Item>
        </div>
    );
}

export default DeliveryInfoInputs;