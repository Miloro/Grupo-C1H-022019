import React from 'react';
import '../App.css';
import Background from "../resources/background.jpg";
import {Col, Icon, Layout, Result, Row, Spin} from "antd";
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import NavBar from "./NavBar";
import {useAuth0} from "../providers/Auth0Provider";
import Buy from "../routes/buy/Buy";
import UnratedOrders from "../routes/UnratedOrders";
import Cart from "../routes/Cart";
import Orders from "../routes/orders/Ordes";
import MenuForm from "../routes/menu/MenuForm";
import Service from "../routes/service/Service";
import Menus from "../routes/menus/Menus";
import ServiceOrders from "../routes/ServiceOrders";
import Home from "../routes/home/Home";
import PrivateRoute from "../routes/PrivateRoute";
import Balance from "../routes/Balance";

const {Header, Content, Footer} = Layout;

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
    style: {paddingTop: '1%'}
};

const colProps = {
    span: 24,
    style: {
        minHeight: "500px"
    }
};

const loadingProps = {
    style : {
        fontSize: 150,
        color: "#ffffff",
        textAlign: "center"
    }
};


function App() {
    const {loading} = useAuth0();

    return (
        <Router>
            <Layout>
                <Header style={{padding: "0 10px 0 10px"}}>
                    <NavBar/>
                </Header>
                <Content>
                    <div {...contentProps}>
                        <Row {...rowProps}>
                            <Col {...colProps}>
                                {loading ?
                                    <Result icon={<Spin indicator={<Icon type="smile" {...loadingProps} spin/>}/>}/>:
                                    <Switch>
                                        <PrivateRoute path="/buy" component={Buy}/>
                                        <PrivateRoute path="/unrated-orders" component={UnratedOrders}/>
                                        <PrivateRoute path="/cart" component={Cart}/>
                                        <PrivateRoute path="/orders" component={Orders}/>
                                        <PrivateRoute path="/service/menu" component={MenuForm}/>
                                        <PrivateRoute path="/service" component={Service}/>
                                        <PrivateRoute path="/menus/:query" component={Menus}/>
                                        <PrivateRoute path="/service/orders" component={ServiceOrders}/>
                                        <PrivateRoute path="/balance" component={Balance}/>
                                        <Route exact path="/" component={Home}/>
                                    </Switch>}
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