import React from 'react'
import "./Service.css";
import {FormattedMessage} from "react-intl";
import {useUser} from "../../providers/UserProvider";
import ServiceForm from "./serviceForm/ServiceForm";
import DefaultResult from "../home/DefaultResult";


const Service = () => {
    const {serviceId} = useUser();

    return !serviceId ?
        <ServiceForm/> :
        <DefaultResult
            icon={"shop"}
            title={<FormattedMessage id="serviceTitle"/>}
            extra={<FormattedMessage id="serviceMessage"/>}
        />;
};

export default Service;