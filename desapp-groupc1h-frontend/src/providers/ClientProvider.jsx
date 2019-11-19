import {StoreProvider} from "./StoreProvider";
import React from "react";

const initialState = {id: null};

const SET_CLIENT_ID = "SET_CLIENT_ID";

const setClientId = (userId) => ({type: SET_CLIENT_ID, payload: {userId}});

const handlers = {
    [SET_CLIENT_ID]: (state, {payload}) => ({
        ...state,
        id: payload
    })
};

const reducer = (state, action) => {
    return handlers[action.type](state, action);
};

const ClientProvider = ({children}) => (
    <StoreProvider initialState={initialState} reducer={reducer}>
        {children}
    </StoreProvider>
);



