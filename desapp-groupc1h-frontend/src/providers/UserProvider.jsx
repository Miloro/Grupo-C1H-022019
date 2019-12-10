import React, {createContext, useContext, useEffect, useState} from "react";
import {useAuth0} from "./Auth0Provider";
import {useAPI} from "./ApiProvider";

export const UserContext = createContext();
export const useUser = () => useContext(UserContext);

export const UserProvider = ({children}) => {
    const {loading, isAuthenticated, user} = useAuth0();
    const {get} = useAPI();
    const [id, setId] = useState(null);
    const [clientId, setClientId] = useState(null);
    const [serviceId, setServiceId] = useState(null);
    const [userLoading, setUserLoading] = useState(true);

    useEffect(() => {
        const fetchUser = () => {
            if (!loading && isAuthenticated) {
                get(`/api/user/${user.email}`,
                    (response) => {
                        if (response.data) {
                            const {clientProfile, serviceProfile} = response.data;
                            setClientId(clientProfile.id);
                            if (serviceProfile) setServiceId(serviceProfile.id);
                            setId(user.email);
                        }
                        setUserLoading(false);
                    }, () => setUserLoading(false))
            }
        };
        fetchUser();
    }, [get, isAuthenticated, loading, user]);

    return (
        <UserContext.Provider
            value={{id, clientId, serviceId, userLoading, setServiceId, setClientId}}
            children={children}
        />
    );
};


