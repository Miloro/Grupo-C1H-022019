import React from 'react';
import './App.css';
import Login from "./routes/Login";
import Background from "./resources/background.jpg";
import {Col, Layout, Menu, Row, Typography} from "antd";
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import MenuMap from "./routes/menus/MenuMap";
import Buy from "./routes/buy/Buy";
import UnratedOrders from "./routes/UnratedOrders";
import Cart from "./routes/Cart";
import Orders from "./routes/Ordes";
import CreateMenu from "./routes/CreateMenu";
import Service from "./routes/service/Service";
import Menus from "./routes/menus/Menus";
import ServiceOrders from "./routes/ServiceOrders";
const { Header, Content, Footer } = Layout;
const {Title} = Typography;

const menuProps = {
  mode: "horizontal",
  defaultSelectedKeys: ['2'],
  style: {lineHeight: '62px'},
};

const contentProps = {
    style: {
        backgroundImage: `url(${Background})`,
        maxWidth: "100%",
        height: "auto",
        padding: '2%'
    }
};

const rowProps = {
    type: "flex",
    justify: "space-around",
    align: "middle",
    style:{paddingTop: '1%'}
};

const colProps = {
    span: 24,
    style:{
        minHeight: "500px"
    }
};

const logoProps= {
    style:{
        fontFamily: "Arial, Helvetica, sans-serif",
        marginTop: 5,
        fontColor: "#FF8C00"
    }
};

function App() {

    return (
        <Router>
        <Layout>
            <Header>
                <Row>
                    <Col span={6}>
                        <div {...logoProps}>
                            <Title > Viandas Ya</Title>
                        </div>
                    </Col>
                    <Col span={8}>
                        <Menu {...menuProps}>
                            <Menu.Item key="1">nav 1</Menu.Item>
                            <Menu.Item key="2">nav 2</Menu.Item>
                        </Menu>
                    </Col>
                </Row>
            </Header>
            <Content>
                <div {...contentProps}>
                    <Row {...rowProps}>
                        <Col {...colProps}>
                            <Switch>
                                <Route path="/map" component={MenuMap}/>
                                <Route path="/buy" component={Buy}/>
                                <Route path="/unrated-orderds" component={UnratedOrders}/>
                                <Route path="/cart" component={Cart}/>
                                <Route path="/orders" component={Orders}/>
                                <Route path="/service/create-menu" component={CreateMenu}/>
                                <Route path="/service" component={Service}/>
                                <Route path="/menus/:query" component={Menus}/>
                                <Route path="/service/orders" component={ServiceOrders}/>
                                <Route exact path="/" component={Login}/>
                            </Switch>
                        </Col>
                    </Row>
                    <a href="https://www.freepik.com/free-photos-vectors/background">Background vector created by
                        freepik - www.freepik.com</a>
                </div>
            </Content>
            <Footer/>
        </Layout>
        </Router>
    );

}

export default App;