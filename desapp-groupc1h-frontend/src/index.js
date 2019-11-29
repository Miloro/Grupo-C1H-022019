import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {IntlProvider} from 'react-intl';
import messagesEn from './translations/en.json';
import messagesEs from './translations/es.json';
import {Auth0Provider} from "./providers/Auth0Provider";
import App from "./components/App";
import {UserProvider} from "./providers/UserProvider";

const messages = {
    'en': messagesEn,
    'es': messagesEs
};

const language = navigator.language.split(/[-_]/)[0]; // language without region code

// A function that routes the user to the right place
// after login
const onRedirectCallback = appState => {
    window.history.replaceState(
        {},
        document.title,
        appState && appState.targetUrl
            ? appState.targetUrl
            : window.location.pathname
    );
};

ReactDOM.render(
    <IntlProvider locale={language} messages={messages[language]}>
        <Auth0Provider
            domain={process.env.REACT_APP_DOMAIN}
            client_id={process.env.REACT_APP_CLIENT_ID}
            redirect_uri={window.location.origin}
            audience={process.env.REACT_APP_AUDIENCE}
            onRedirectCallback={onRedirectCallback}
        >
            <UserProvider>
                <App/>
            </UserProvider>
        </Auth0Provider>
    </IntlProvider>
    , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
