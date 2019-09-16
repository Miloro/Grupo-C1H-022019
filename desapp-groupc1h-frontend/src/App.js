import React, {Component} from 'react';
import { Route, BrowserRouter as Router } from 'react-router-dom'
import './App.css';
import Login from './js/Login';

class App extends Component {

  state = {};

  componentDidMount() {
    setInterval(this.hello, 250);
  }

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
            <Route path="/" exact component={Login} />
        </Router>
    );
  }
}

export default App;
