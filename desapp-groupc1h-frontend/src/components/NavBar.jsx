import React from 'react';
import {Button, Col, Menu, Row, Typography} from "antd";
import MenuSearchInput from "../routes/menus/MenuSearchInput";
import {useAuth0} from "../providers/Auth0Provider";
import {useUser} from "../providers/UserProvider";
import {FormattedMessage} from "react-intl";

const {Title} = Typography;

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
    const {isAuthenticated, loading, logout} = useAuth0();
    const [{id}, ] = useUser();

    return <Row>
        <Col span={5}>
            <div {...logoProps}>
                <Title> Viandas Ya</Title>
            </div>
        </Col>
        <Col span={12} style={{paddingTop: '1%'}}>
            <MenuSearchInput/>
        </Col>
        <Col span={7}>
            <Menu {...menuProps}>
                <Menu.Item key="1">nav 1</Menu.Item>
                <Menu.Item key="2">nav 2</Menu.Item>
                <Menu.Item key="3">
                    {(!loading) && isAuthenticated && id &&
                    <Button type="primary" onClick={() => logout()}>
                        <FormattedMessage id="logout"/>
                    </Button>}
                </Menu.Item>
            </Menu>
        </Col>
    </Row>
};

export default NavBar;