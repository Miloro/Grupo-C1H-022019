import React, {useEffect} from 'react';
import {useAuth0} from "../../providers/Auth0Provider";
import {get} from "../../api/API";
import Register from "./Register";
import {setUserId, useUser} from "../../providers/UserProvider";
import {Redirect} from "react-router-dom";

const Client = () => {
    const {getTokenSilently, user} = useAuth0();
    const [{id}, dispatch] = useUser();

    useEffect(() => {
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
        return <Register/>;
    }

};

export default Client;