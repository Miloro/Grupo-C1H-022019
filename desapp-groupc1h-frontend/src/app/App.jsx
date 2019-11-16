import React from 'react';
import '../App.css';
import Background from "../resources/background.jpg";
import {Col, Layout, Row, Spin} from "antd";
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import NavBar from "./NavBar";
import {useAuth0} from "../security/Auth0Provider";
import Buy from "../routes/buy/Buy";
import UnratedOrders from "../routes/UnratedOrders";
import Cart from "../routes/Cart";
import Orders from "../routes/Ordes";
import CreateMenu from "../routes/CreateMenu";
import Service from "../routes/service/Service";
import Menus from "../routes/menus/Menus";
import ServiceOrders from "../routes/ServiceOrders";
import Profile from "../routes/Client/Profile";
import Client from "../routes/Client/Client";
import Login from "../routes/Login";
import PrivateRoute from "../security/PrivateRoute";
const { Header, Content, Footer } = Layout;

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


function App() {
    const { isAuthenticated, loading} = useAuth0();

    const ShowIfNotLoading = () => {
        if (loading) {
            return <Spin size="large" spinning={loading}/>
        } else {
            return <Switch>
                <Route path="/buy" component={Buy}/>
                <Route path="/unrated-orderds" component={UnratedOrders}/>
                <Route path="/cart" component={Cart}/>
                <Route path="/orders" component={Orders}/>
                <Route path="/service/create-menu" component={CreateMenu}/>
                <Route path="/service" component={Service}/>
                <Route path="/menus/:query" component={Menus}/>
                <Route path="/service/orders" component={ServiceOrders}/>
                <PrivateRoute path="/profile" component={Profile}/>
                <Route exact path="/">
                    {isAuthenticated ? <Client/> : <Login/> }
                </Route>
            </Switch>
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