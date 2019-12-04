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
import Orders from "../routes/Ordes";
import MenuForm from "../routes/menu/form/MenuForm";
import Service from "../routes/service/Service";
import Menus from "../routes/menus/Menus";
import ServiceOrders from "../routes/ServiceOrders";
import Login from "../routes/Login";
import Client from "../routes/client/Client";
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


function App() {
    const {isAuthenticated, loading} = useAuth0();

    const ShowIfNotLoading = () => {
        if (loading) {
            return <Result
                icon={<Spin indicator={
                    <Icon type="smile" style={{fontSize: 150, color: "#ffffff", textAlign: "center"}} spin/>
                }
                />
                }/>
        } else {
            return <Row type="flex" justify="space-around" align="middle">
                <Col span={20} style={{backgroundColor: "#ffffff"}}>
                    <Switch>
                        <PrivateRoute path="/buy" component={Buy}/>
                        <PrivateRoute path="/unrated-orderds" component={UnratedOrders}/>
                        <PrivateRoute path="/cart" component={Cart}/>
                        <PrivateRoute path="/orders" component={Orders}/>
                        <PrivateRoute path="/service/menu" component={MenuForm}/>
                        <PrivateRoute path="/service" component={Service}/>
                        <PrivateRoute path="/menus/:query" component={Menus}/>
                        <PrivateRoute path="/service/orders" component={ServiceOrders}/>
                        <PrivateRoute path="/balance" component={Balance}/>
                        <Route exact path="/">
                            {isAuthenticated ? <Client/> : <Login/>}
                        </Route>
                    </Switch>
                </Col>
            </Row>
        }
    };

    return (
        <Router>
            <Layout>
                <Header>
                    <NavBar/>
                </Header>
                <Content>
                    <div {...contentProps}>
                        <Row {...rowProps}>
                            <Col {...colProps}>
                                <ShowIfNotLoading/>
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