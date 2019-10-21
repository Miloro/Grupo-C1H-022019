import React from 'react'
import {FormattedMessage} from 'react-intl'
import ServiceForm from "./ServiceForm";
import { Layout, Menu} from "antd";
import "./Service.css";


class Service  extends React.Component{

    render(){
        return(
            <div className= "App" >
                <Layout className="layout">
                    <Layout.Header>
                        <div className="logo" />
                        <Menu
                            theme="dark"
                            mode="horizontal"
                            defaultSelectedKeys={['2']}
                            style={{ lineHeight: '64px' }}
                        >
                        </Menu>
                    </Layout.Header>
                    <Layout.Content style={{ padding: '0 50px' }}>
                        <div style={{ background: '#fff', padding: 24, minHeight: 425 }}>
                            <ServiceForm/>
                            <h1><FormattedMessage id="Greet"/></h1>
                            <h1><FormattedMessage id="Service"/></h1>
                        </div>
                    </Layout.Content>
                    <Layout.Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Layout.Footer>
                </Layout>
            </div>
        )
    }

}

export default Service;