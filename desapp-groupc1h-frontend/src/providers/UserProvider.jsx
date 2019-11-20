import React, {createContext, useContext, useReducer} from "react";

const initialState = {id: null, clientId: null};

const SET_USER_ID = "SET_USER_ID";

export const setUserId = userId => ({type: SET_USER_ID, payload: {userId}});

const handlers = {
    [SET_USER_ID]: (state, {payload}) => ({
        ...state,
        id: payload.userId
    })
};

const reducer = (state, action) => {
    return handlers[action.type](state, action);
};

export const UserContext = createContext();

export const UserProvider = ({children}) => (
    <UserContext.Provider
        value={useReducer(reducer, initialState)}
        children={children}
    />
);

export const useUser = () => useContext(UserContext);




