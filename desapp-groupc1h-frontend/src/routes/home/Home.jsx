import React from 'react';
import {useAuth0} from "../../providers/Auth0Provider";
import {useUser} from "../../providers/UserProvider";
import ClientForm from "./ClientForm";
import {FormattedMessage} from "react-intl";
import DefaultResult from "./DefaultResult";
import {Button} from "antd";

const Home = () => {
    const {isAuthenticated, loading, loginWithRedirect} = useAuth0();
    const {clientId} = useUser();

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
                title={<FormattedMessage id="welcomeTitle"/>}
                extra={<FormattedMessage id="welcomeMessage"/>}
            />;
};

export default Home;