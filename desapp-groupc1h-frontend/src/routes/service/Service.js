import React, {useState} from 'react'
import {Col, Layout, Menu, Row} from "antd";
import "./Service.css";
import ServiceForm from "./serviceForm/ServiceForm";

function Service(props) {
    const userId = 21;
    const [service, setService] = useState(null);

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
                                {!service && <ServiceForm userId={userId} setService={setService}/>}
                            </Col>
                        </Row>
                    </Layout.Content>
                    <Layout.Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Layout.Footer>
                </Layout>
            </div>
        );

}

export default Service;