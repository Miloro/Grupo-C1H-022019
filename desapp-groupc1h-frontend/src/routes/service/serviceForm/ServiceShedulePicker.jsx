import React from 'react';
import {Col, Row} from "antd";
import {Checkbox, Form, TimePicker} from "formik-antd";
import {useIntl} from "react-intl";
const {Item} = Form;


function ServiceShedulePicker({timetable, setFieldValue}) {
    const {formatMessage} = useIntl();
    const format = 'HH:mm';

    function onChange(time, timeString, hourTime) {
        setFieldValue(hourTime, time);
    }

    return (
        <Row gutter={[16, 16]}>
            {timetable.map((slot, index) =>
            <div key={slot.day}>
                <Col span={4}>
                    <Item name={`timetable[${index}].checked`}>
                        <Checkbox name={`timetable[${index}].checked`}>{formatMessage({id: slot.day})}</Checkbox>
                    </Item>
                </Col>
                {['from', 'to'].map((range) => {
                    const hourTime = `timetable[${index}].${range}`;
                    return <Col span={4} key={range}>
                        <Item name={hourTime}>
                            <TimePicker name={hourTime}
                                        placeholder={formatMessage({id: "selectTime"})}
                                        format={format} disabled={!slot.checked}
                                        minuteStep={15}
                                        onChange={(time, timeString) => onChange(time, timeString, hourTime)}
                            />
                        </Item>
                    </Col>
                })}
            </div>
        )}
        </Row>
    );

}


export default ServiceShedulePicker;