import React from 'react'
import ServiceForm from "./ServiceForm";
import {Col, Layout, Menu, Row} from "antd";
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
                    <Layout.Content>
                        <Row type="flex" justify="space-around" align="middle">
                            <Col span={16} style={{ background: '#fff', padding: 40, minHeight: 400 }}>
                                <ServiceForm/>
                            </Col>
                        </Row>
                    </Layout.Content>
                    <Layout.Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Layout.Footer>
                </Layout>
            </div>
        )
    }

}

export default Service;