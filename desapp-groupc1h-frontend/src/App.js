import React, { Component, Suspense } from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import './App.css';
import Login from './js/Login';
import MapDev from './js/MapDev';
import { injectIntl } from 'react-intl';

class App extends Component {

  state = {};

  hello = () => {
    fetch('/api/hello')
        .then(response => response.text())
        .then(message => {
          this.setState({message: message});
        });
  };
  

  render() {
    const intl = this.props.intl
    return (
      <BrowserRouter>
        <Suspense fallback={Login}>
          <Switch>
            <Route exact path="/" component={Login}/>
            <Route exact path="/mapdev" component={MapDev}/>
          </Switch>
        </Suspense>
      </BrowserRouter>
    );
  }
}

App = injectIntl(App)

export default App;