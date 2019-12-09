import React from 'react';
import {useAuth0} from "../../providers/Auth0Provider";
import {useUser} from "../../providers/UserProvider";
import ClientForm from "./ClientForm";
import {FormattedMessage} from "react-intl";
import DefaultResult from "./DefaultResult";
import {Button} from "antd";

const Home = () => {
    const {isAuthenticated, loading, loginWithRedirect, user} = useAuth0();
    const {clientId} = useUser();

    const capitalize = (s) => {
        if (typeof s !== 'string') return '';
        return s.charAt(0).toUpperCase() + s.slice(1)
    };

    return !(isAuthenticated || clientId) ?
        <DefaultResult
            icon={"home"}
            title={<FormattedMessage id="visitorMessage"/>}
            extra={!loading && <Button size="large" onClick={() => loginWithRedirect({})}>
                <FormattedMessage id="login"/>
            </Button>}
        /> :
        isAuthenticated && !clientId ?
            <ClientForm/> :
            <DefaultResult
                icon={"home"}
                title={<FormattedMessage id="welcomeTitle" values={{name: capitalize(user.given_name)}}/>}
                extra={<FormattedMessage id="welcomeMessage"/>}
            />;
};

export default Home;