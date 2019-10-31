import React from 'react';
import {Col, Row} from "antd";
import {Checkbox, Form, TimePicker} from "@jbuschke/formik-antd";
import {useIntl} from "react-intl";
const {Item} = Form;


function ServiceShedulePicker({timetable, setFieldValue}) {
    const {formatMessage} = useIntl();
    const format = 'HH:mm';

    function onChange(time, timeString, hourTime) {
        setFieldValue(hourTime, time);
    }

    return (
        timetable.map((slot, index) =>
            <Row key={slot.day}>
                <Col span={6}>
                    <Item name={`timetable[${index}].checked`}>
                        <Checkbox name={`timetable[${index}].checked`}>{formatMessage({id:slot.day})}</Checkbox>
                    </Item>
                </Col>
                {['from', 'to'].map((range) => {
                    const hourTime = `timetable[${index}].${range}`;
                    return <Col span={4} key={range}>
                            <Item name={hourTime}>
                                <TimePicker name={hourTime}
                                            placeholder={formatMessage({id:"selectTime"})}
                                            format={format} disabled={!slot.checked}
                                            onChange={(time, timeString) => onChange(time, timeString, hourTime)}
                                />
                            </Item>
                        </Col>
                })}
            </Row>
        )
    );

}


export default ServiceShedulePicker;