import React, {useEffect, useState} from 'react';
import {useAuth0} from "../../security/Auth0Provider";
import {Button, Col, Icon, Result, Row} from "antd";
import {get} from "../../api/API";
import ClientForm from "./ClientForm";

const styleProps = {
    style: {
        fontSize: 50,
        color: '#ffffff'
    }
};

const Client = () => {
    const {logout, loading, getTokenSilently} = useAuth0();
    const [clientId, setClientId] = useState(null);
    //
    // useEffect(() => {
    //     get(getTokenSilently,
    //         (response) => (
    //             setClientId(response.data)
    //         ));
    //
    // });

    if (!clientId) {
        return <Row type="flex" justify="space-around" align="middle">
            <Col span={20} style={{backgroundColor: "#ffffff"}}>
                <ClientForm/>
            </Col>
        </Row>
    }

    return <Result
        icon={<Icon type="home"  {...styleProps}/>}
        title={<div {...styleProps}> Hasta Luego! </div>}
        extra={!loading && <Button type="primary" size="large" onClick={() => logout()}>
            Logout
        </Button>}
    />;
};

export default Client;