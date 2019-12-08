import React, {useContext} from "react";
import axios from "axios";
import {useAuth0} from "./Auth0Provider";

export const ApiContext = React.createContext();
export const useAPI = () => useContext(ApiContext);

export const ApiProvider = ({children}) => {
    const {getTokenSilently, user} = useAuth0();


    const axiosRequest = async (method, url, data, then,
                                catchIt = (error) => (console.error(JSON.stringify(error)))) => {
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

    const getUnratedOrders = (then, catchIt) => {
        get("/api/orders/unrated", then, catchIt)
    };

    return (<ApiContext.Provider
        value={{get, post, put, postClient, postService, postMenu, searchMenus, getUnratedOrders}}>
        {children}
    </ApiContext.Provider>);
};