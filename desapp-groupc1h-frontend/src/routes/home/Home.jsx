import React from 'react';
import {Switch, Route} from "react-router-dom";
import MenuMap from "../menus/MenuMap";
import Buy from "../buy/Buy";
import UnratedOrders from "../UnratedOrders";
import Cart from "../Cart";
import Orders from "../Ordes";
import CreateMenu from "../CreateMenu";
import Service from "../service/Service";
import Menus from "../menus/Menus";
import ServiceOrders from "../ServiceOrders";
import {Col, Row} from "antd";

function Home() {

    return (
        <Row>
            <Col>
                <Switch>
                    <Route exact path="/map" component={MenuMap}/>
                    <Route exact path="/buy" component={Buy}/>
                    <Route exact path="/unrated-orderds" component={UnratedOrders}/>
                    <Route exact path="/cart" component={Cart}/>
                    <Route exact path="/orders" component={Orders}/>
                    <Route exact path="/service/create-menu" component={CreateMenu}/>
                    <Route exact path="/service" component={Service}/>
                    <Route exact path="/menus/:query" component={Menus}/>
                    <Route exact path="/service/orders" component={ServiceOrders}/>
                </Switch>
            </Col>
        </Row>

     );

}

export default Home;