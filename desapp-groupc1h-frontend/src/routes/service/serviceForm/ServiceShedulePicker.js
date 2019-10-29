import React from 'react';
import {Col, Row} from "antd";
import {Checkbox, Form, TimePicker} from "@jbuschke/formik-antd";
import {useIntl} from "react-intl";
const {Item} = Form;

function ServiceShedulePicker({timetable}) {
    const {formatMessage} = useIntl();
    const format = 'HH:mm';

    return (
        timetable.map((slot, index) =>
            <Row key={slot.name}>
                <Col span={6}>
                    <Item name={`timetable[${index}].checked`}>
                        <Checkbox name={`timetable[${index}].checked`}>{formatMessage({id:slot.name})}</Checkbox>
                    </Item>
                </Col>
                <Col span={4}>
                    <Item name={`timetable[${index}].from`}>
                        <TimePicker name={`timetable[${index}].from`} format={format} disabled={!slot.checked}/>
                    </Item>
                </Col>
                <Col span={4}>
                    <Item name={`timetable[${index}].to`}>
                        <TimePicker name={`timetable[${index}].to`} format={format} disabled={!slot.checked}/>
                    </Item>
                </Col>
            </Row>
        )
    );

}


export default ServiceShedulePicker;