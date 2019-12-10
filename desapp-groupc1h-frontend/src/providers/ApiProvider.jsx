import React, {useContext} from "react";
import axios from "axios";
import {useAuth0} from "./Auth0Provider";
import {useIntl} from "react-intl";
import {Icon, notification, Typography} from "antd";
const {Paragraph} = Typography;

export const ApiContext = React.createContext();
export const useAPI = () => useContext(ApiContext);

export const ApiProvider = ({children}) => {
    const {getTokenSilently, user} = useAuth0();
    const {formatMessage} = useIntl();

    const defaultCatchBlock = ({response}) => {
        let message = `Status ${response.status}`;
        let descriptionTitle = response.statusText;
        let errors = {};
        console.log(JSON.stringify(response));
        if (response.status === 400) errors = response.data;
        if (response.status === 412) errors = {"Service": "max20ValidMenus"};
        if (response.status === 418) {
            errors = {"offers": "invalidOffers"};
            message = "Status 400";
            descriptionTitle = "Bad Request";
        }
        return notification.error({
            duration: 0,
            message: message,
            description: <div>
                <Paragraph>{descriptionTitle}</Paragraph>
                {Object.entries(errors)
                    .map(([field, message], index) =>
                        (<Paragraph key={index}>
                            <Icon style={{color: 'red'}} type="close-circle"/>
                            {`${formatMessage({id: field})}: ${formatMessage({id: message})}`}
                        </Paragraph>))}
            </div>
        });
    };

    const axiosRequest = async (method, url, data, then, catchIt = () => {
    }) => {
        try {
            const token = await getTokenSilently();
            const response = await axios({
                method: method,
                url: url,
                ...data,
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            then(response);
        } catch (error) {
            catchIt(error);
            defaultCatchBlock(error);
        }
    };

    const get = (url, then, catchIt) => {
        axiosRequest("get", url, {}, then, catchIt);
    };

    const post = (url, data, then, catchIt) => {
        axiosRequest("post", url, {data: data}, then, catchIt);
    };

    const put = (url, data, then, catchIt) => {
        axiosRequest("put", url, {data: data}, then, catchIt);
    };

    const postClient = (client, then, catchIt) => {
        post(`/api/user/${user.email}`, client, then, catchIt)
    };

    const postService = (service, then, catchIt) => {
        post(`/api/user/${user.email}/service`, service, then, catchIt)
    };

    const postMenu = (serviceId, menu, then, catchIt) => {
        post(`/api/service/${serviceId}/menu`, menu, then, catchIt)
    };

    const searchMenus = (search, then, catchIt) => {
        post("/api/menus/search", search, then, catchIt)
    };

    const getUnratedOrders = (clientId, then, catchIt) => {
        get(`/api/client/${clientId}/orders/unrated`, then, catchIt)
    };

    const updateScore = (orderId, score, then, catchIt) => {
        put(`/api/order/${orderId}/score`, {score: score}, then, catchIt)
    };

    return (<ApiContext.Provider
        value={{get, post, put, postClient, postService, postMenu, searchMenus, getUnratedOrders, updateScore}}>
        {children}
    </ApiContext.Provider>);
};