import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker'
import { IntlProvider } from 'react-intl'
import 'bootstrap/dist/css/bootstrap.min.css';
//import $ from 'jquery';
//import Popper from 'popper.js';
import 'bootstrap/dist/js/bootstrap.bundle.min';

import messagesEn from './translations/en.json'
import messagesEs from './translations/es.json'

const messages = {
  'en': messagesEn,
  'es': messagesEs
};

const language = navigator.language.split(/[-_]/)[0]; // language without region code

ReactDOM.render(
  <IntlProvider locale={language} messages={messages[language]}>
    <App />
  </IntlProvider>
  , document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
