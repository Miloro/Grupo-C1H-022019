import React, {useContext} from "react";
import axios from "axios";
import {Auth0Context, useAuth0} from "./Auth0Provider";

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

    return (<ApiContext.Provider value={{get, post, put, postClient}}>
        {children}
    </ApiContext.Provider>);
};