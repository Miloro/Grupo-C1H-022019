import React, {useState} from 'react'
import "./Service.css";
import ServiceForm from "./serviceForm/ServiceForm";
import {Col, Row} from "antd";

function Service() {
    const userId = 261;
    const [service, setService] = useState(null);

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col span={20} style={{backgroundColor: "#ffffff"}}>
                {!service && <ServiceForm userId={userId} setService={setService}/>}
            </Col>
        </Row>

    );

}

export default Service;