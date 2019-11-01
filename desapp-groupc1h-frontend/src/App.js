import React, { Component, Suspense } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './routes/Login';
import Home from './routes/home/Home';
import MapDev from './routes/MapDev';
import Service from './routes/service/Service';
import Buy from './routes/Buy';
import UnratedOrderds from './routes/UnratedOrderds';
import Cart from './routes/Cart';
import CreateMenu from './routes/CreateMenu';
import Menus from './routes/Menus';
import ServiceOrders from './routes/ServiceOrders';
import Orders from './routes/Ordes';
import { injectIntl } from 'react-intl';


class App extends Component {

  state = {};

  render() {
    //const intl = this.props.intl
    return (
      <BrowserRouter>
        <Suspense fallback={Login}>
        <Route exact path="/" component={Login}/> 
          <Switch>
            <Route exact path="/home" component={Home}/>
            <Route exact path="/mapdev" component={MapDev}/>
            <Route exact path="/buy" component={Buy}/>
            <Route exact path="/unrated-orderds" component={UnratedOrderds}/>
            <Route exact path="/cart" component={Cart}/>
            <Route exact path="/orders" component={Orders}/>
            <Route exact path="/service" component={Service}/>
            <Route exact path="/service/create-menu" component={CreateMenu}/>
            <Route exact path="/service/menus" component={Menus}/>
            <Route exact path="/service/orders" component={ServiceOrders}/>
          </Switch>
        </Suspense>
      </BrowserRouter>
    );
  }
}

App = injectIntl(App);

export default App;