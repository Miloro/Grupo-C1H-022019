import React, {useState} from 'react'
import "./Service.css";
import ServiceForm from "./serviceForm/ServiceForm";
import {useUser} from "../../providers/UserProvider";
import {Col, Row} from "antd";

function Service() {
    const userId = "miloromiguel@gmail.com";
    const [service, setService] = useState(null);
    const [{id}, ] = useUser();

    return (
        
        <Row type="flex" justify="space-around" align="middle">
            <Col span={20} style={{backgroundColor: "#ffffff"}}>
                {id.serviceProfileEmail === null && <ServiceForm userId={id.email} setService={setService}/>}
            </Col>
        </Row>

    );

}

export default Service;