import React, {useState} from 'react'
import "./Service.css";
import ServiceForm from "./serviceForm/ServiceForm";
import {useUser} from "../../providers/UserProvider";
import {Col, Row} from "antd";

function Service() {
    const userId = "miloromiguel@gmail.com";
    const [service, setService] = useState(null);
    const [{id}, ] = useUser();


    return (!service && <ServiceForm userId={userId} setService={setService}/>);

}

export default Service;