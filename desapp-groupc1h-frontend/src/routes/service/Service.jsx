import React, {useState} from 'react'
import "./Service.css";
import ServiceForm from "./serviceForm/ServiceForm";

function Service() {
    const userId = 213;
    const [service, setService] = useState(null);

    return (
        !service && <ServiceForm userId={userId} setService={setService}/>
    );

}

export default Service;