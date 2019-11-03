import React from 'react';
import {Col, Radio, Row} from "antd";
const {Group} = Radio;

function MenuOrderRadio(props) {

    function onChange() {
    }

    return (
        <Row type="flex" justify= "space-around" align= "middle">
            <Col span={14}>
                <Group onChange={onChange} name="orders" size="large">
                    <Radio value={1}>Menor Precio</Radio>
                    <Radio value={2}>Mayor Precio</Radio>
                    <Radio value={3}>Menor Puntuacion</Radio>
                    <Radio value={4}>Mayor Puntuacion</Radio>
                </Group>
            </Col>
            <Col span={6} offset={1}>
                <Group onChange={onChange} name="display" size="large">
                    <Radio value={1}>Map</Radio>
                    <Radio value={2}>List</Radio>
                </Group>
            </Col>
        </Row>
    );
}

export default MenuOrderRadio;