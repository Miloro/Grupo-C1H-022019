import React from 'react';
import {Col, Icon, Menu, Row, Tooltip, Typography} from "antd";
import MenuSearchInput from "../routes/menus/MenuSearchInput";
import {useUser} from "../providers/UserProvider";
import {useHistory} from "react-router-dom";
import MenuOption from "./MenuOption";
import {useIntl} from "react-intl";
import {useAuth0} from "../providers/Auth0Provider";

const {Title} = Typography;
const {Item, SubMenu} = Menu;

const menuProps = {
    mode: "horizontal",
    defaultSelectedKeys: ['2'],
    style: {lineHeight: '62px'},
};

const logoProps = {
    style: {
        fontFamily: "Arial, Helvetica, sans-serif",
        marginTop: 5,
        fontColor: "#FF8C00"
    }
};

const NavBar = () => {
    const {formatMessage} = useIntl();
    const [{id, serviceId},] = useUser();
    const {isAuthenticated} = useAuth0();
    let history = useHistory();

    return <Row>
        <Col span={4}>
            <div {...logoProps}>
                <Title level={2}> Viandas Ya</Title>
            </div>
        </Col>
        {isAuthenticated &&
        <Col span={10} style={{paddingTop: '1%'}}>
            <MenuSearchInput/>
        </Col>}
        <Col span={10}>
            {id &&
            <Menu {...menuProps}>
                <Item key="1"><Icon type="home"/></Item>
                <SubMenu title={<MenuOption icon="user" name={formatMessage({id:"profile"})}/>}>
                    <Item key="2"><MenuOption icon="shopping" name={formatMessage({id:"Orders"})}/></Item>
                    <Item key="3"><MenuOption icon="star" name={formatMessage({id:"rateOrders"})}/></Item>
                    <Item key="4"><MenuOption icon="form" name={formatMessage({id:"updateProfile"})}/></Item>
                </SubMenu>
                {serviceId &&
                <SubMenu title={<MenuOption icon="shop" name={formatMessage({id:"Service"})}/>}>
                    <Item key="5"><MenuOption icon="shopping" name={formatMessage({id:"Orders"})}/></Item>
                    <Item key="6"><MenuOption icon="setting" name={formatMessage({id:"myMenus"})}/></Item>
                    <Item key="7"><MenuOption icon="form" name={formatMessage({id:"CreateMenu"})}/></Item>
                </SubMenu>}
                <Item key="8"><Tooltip title={formatMessage({id:"wallet"})}><Icon type="dollar"/></Tooltip></Item>
                <Item key="9"><Tooltip title={formatMessage({id:"logout"})}><Icon type="logout"/></Tooltip></Item>
            </Menu>}
        </Col>
    </Row>
};

export default NavBar;