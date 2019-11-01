import Background from '../../resources/background.jpg';
import React from 'react';
import {Button, Col, Layout, Menu, Result, Row} from 'antd';
const { Header, Content, Footer } = Layout;



function Home(props) {
    return (
        <Layout>
            <Header>
                <Menu
                    theme="dark"
                    mode="horizontal"
                >
                </Menu>
            </Header>
            <Content>
                <div style={{backgroundImage: `url(${Background})`, height: '100%'}}>
                <Row>
                    <Col span={24}>
                        <Result
                            status="success"
                            title="Successfully Purchased Cloud Server ECS!"
                            subTitle="Order number: 2017182818828182881 Cloud server configuration takes 1-5 minutes, please wait."
                            extra={[
                                <Button type="primary" key="console">
                                    Go Console
                                </Button>,
                                <Button key="buy">Buy Again</Button>,
                            ]}
                        />
                    </Col>
                </Row>
                </div>
            </Content>
            <Footer/>
        </Layout>
    );
}

export default Home;