import React from 'react';
import {Col, Radio, Row} from "antd";
import {useIntl} from "react-intl";
const {Group} = Radio;

function MenuOrderRadio(props) {
    const {formatMessage} = useIntl();

    function onChange() {
    }

    return (
        <Row type="flex" justify= "space-around" align= "middle">
            <Col span={14}>
                <Group onChange={onChange} name="orders" size="large">
                    <Radio value={1}>{formatMessage({id: "lowestPrice"})}</Radio>
                    <Radio value={2}>{formatMessage({id: "highestPrice"})}</Radio>
                    <Radio value={3}>{formatMessage({id: "lowestRating"})}</Radio>
                    <Radio value={4}>{formatMessage({id: "highestRating"})}</Radio>
                </Group>
            </Col>
            <Col span={6}>
                <Group onChange={onChange} name="layout" buttonStyle="solid">
                    <Radio.Button value={1}>{formatMessage({id: "map"})}</Radio.Button>
                    <Radio.Button value={2}>{formatMessage({id: "list"})}</Radio.Button>
                </Group>
            </Col>
        </Row>
    );
}

export default MenuOrderRadio;