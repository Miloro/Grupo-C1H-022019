import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import { IntlProvider } from 'react-intl';
import {BrowserRouter as Router, Route} from "react-router-dom";

import messagesEn from './translations/en.json';
import messagesEs from './translations/es.json';
import App from "./App";

const messages = {
  'en': messagesEn,
  'es': messagesEs
};

const language = navigator.language.split(/[-_]/)[0]; // language without region code

ReactDOM.render(
  <IntlProvider locale={language} messages={messages[language]}>
      <Router>
          <Route exact path="/" component={App}/>
      </Router>
  </IntlProvider>
  , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
