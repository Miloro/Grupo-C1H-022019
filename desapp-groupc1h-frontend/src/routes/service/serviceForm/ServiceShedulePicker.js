import React from 'react';
import {Col, Row} from "antd";
import {Checkbox, Form, TimePicker} from "@jbuschke/formik-antd";

function ServiceShedulePicker({timetable}) {
    const format = 'HH:mm';

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


export default ServiceShedulePicker;