import React, {Component} from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom'
import './App.css';
import Login from './js/Login';
import MapDev from './js/MapDev';

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
    return (
        <Router>
            <div>
                <Route path="/" exact component={Login} />
                <Route path="/mapdev" component={MapDev} />
            </div>
        </Router>
    );
  }
}

export default App;
