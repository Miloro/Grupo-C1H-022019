import React, { Component, Suspense } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './routes/Login';
import Home from './routes/home/Home';
import MapDev from './routes/MapDev';
import Service from './routes/service/Service';
import Buy from './routes/buy/Buy';
import UnratedOrders from './routes/UnratedOrders';
import Cart from './routes/Cart';
import CreateMenu from './routes/CreateMenu';
import Menus from './routes/Menus';
import ServiceOrders from './routes/ServiceOrders';
import Orders from './routes/Ordes';
import { injectIntl } from 'react-intl';
import {Col, Layout, Menu, Row} from 'antd';
import Background from "./resources/background.jpg";
const { Header, Content, Footer } = Layout;

const menuProps = {
  mode: "horizontal",
  defaultSelectedKeys: ['28'],
  style: {lineHeight: '64px'},
};

const contentProps = {
  style: {
    backgroundImage: `url(${Background})`,
    center : 0,
    minHeight: '100%',
    height: '100%',
    padding: '100px'
    
  }
};

const rowProps = {
  type: "flex",
  justify: "space-around",
  align: "middle",
  style:{paddingTop: '2%', }
};

const colProps = {
    span: 20,
    style:{
      background: '#f5f5f5',
      borderRadius: '25px'
    }
};

class App extends Component {

  render() {
    return (
      <BrowserRouter>
        <Layout style={{minHeight:"100vh"}}>
          <Header>
            <Menu {...menuProps}>
              <Menu.Item key="1">nav 1</Menu.Item>
              <Menu.Item key="2">nav 2</Menu.Item>
              <Menu.Item key="3">nav 3</Menu.Item>
              <Menu.Item key="4">nav 4</Menu.Item>
            </Menu>
          </Header>
          <Content>
            <div {...contentProps}>
              <Row {...rowProps}>
                  <Col {...colProps}>
                  <Suspense fallback={Home}>
                    <Route exact path="/" component={Home}/>
                    <Switch>
                      <Route exact path="/login" component={Login}/>
                      <Route exact path="/mapdev" component={MapDev}/>
                      <Route exact path="/buy" component={Buy}/>
                      <Route exact path="/unrated-orderds" component={UnratedOrders}/>
                      <Route exact path="/cart" component={Cart}/>
                      <Route exact path="/orders" component={Orders}/>
                      <Route exact path="/service" component={Service}/>
                      <Route exact path="/service/create-menu" component={CreateMenu}/>
                      <Route exact path="/service/menus" component={Menus}/>
                      <Route exact path="/service/orders" component={ServiceOrders}/>
                    </Switch>
                  </Suspense>
                  </Col>
              </Row>
            </div>
          </Content>
          <Footer style={{ textAlign: 'center',  position: "sticky", bottom: "" }}>comidas muy ricas</Footer>
        </Layout>
      </BrowserRouter>
    );
  }
}

App = injectIntl(App);

export default App;