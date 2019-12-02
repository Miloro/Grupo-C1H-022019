import React from 'react';
import {Col, Row} from "antd";
import {Checkbox, Form, TimePicker} from "formik-antd";
import {useIntl} from "react-intl";
const {Item} = Form;


function SchedulePicker({timetableName, timetable, setFieldValue}) {
    const {formatMessage} = useIntl();
    const format = 'HH:mm';

    const onChange = (time, timeString, hourTime) => {
        setFieldValue(hourTime, time);
    };

    return (
        <Row gutter={[16, 16]}>
            {timetable.map((slot, index) =>
            <div key={slot.day}>
                <Col span={4}>
                    <Item name={`${timetableName}[${index}].checked`}>
                        <Checkbox name={`${timetableName}[${index}].checked`}>{formatMessage({id: slot.day})}</Checkbox>
                    </Item>
                </Col>
                {['from', 'to'].map((range) => {
                    const hourTime = `${timetableName}[${index}].${range}`;
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


export default SchedulePicker;