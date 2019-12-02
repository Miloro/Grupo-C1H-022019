import React, {useEffect} from 'react';
import {useAuth0} from "../../providers/Auth0Provider";
import {Col, Row} from "antd";
import {get} from "../../api/API";
import Register from "./Register";
import {setUserId, useUser} from "../../providers/UserProvider";
import {Redirect} from "react-router-dom";

const Client = () => {
    const {getTokenSilently, user} = useAuth0();
    const [{id}, dispatch] = useUser();

    useEffect(() => {
        console.log(user);
        get(getTokenSilently,
            `/api/user/email/${user.email}`,
            (response) => {
                if (response.data) {
                    dispatch(setUserId(response.data));
                    console.log(response.data)
                }
            });
    }, [dispatch, getTokenSilently, user]);

    if (id) {
        return <Redirect to="/menus/search"/>
    }
    else {
        return <Row type="flex" justify="space-around" align="middle">
            <Col span={20} style={{backgroundColor: "#ffffff"}}>
                <Register/>
            </Col>
        </Row>;
    }

};

export default Client;