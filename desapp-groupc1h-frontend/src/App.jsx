import React, {useState} from 'react';
import './App.css';
import Login from "./routes/Login";
import Home from "./routes/home/Home";
import Background from "./resources/background.jpg";
import {Col, Layout, Menu, Row, Typography} from "antd";
const { Header, Content, Footer } = Layout;
const {Title} = Typography;

const menuProps = {
  mode: "horizontal",
  defaultSelectedKeys: ['2'],
  style: {lineHeight: '62px'},
};

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

const logoProps= {
    style:{
        fontFamily: "Arial, Helvetica, sans-serif" ,
        marginTop: 5,
        fontColor: "#FF8C00"
    }
};

function App() {
    const [userId, setUserId] = useState(1);

    const CurrentPage = () => {
        if (userId) {
            return <Home/>
        }
        else {
            return <Login/>
        }
    };

    return (
        <Layout>
            <Header>
                <Row>
                    <Col span={6}>
                        <div {...logoProps}>
                            <Title > Viandas Ya</Title>
                        </div>
                    </Col>
                    <Col span={8}>
                        <Menu {...menuProps}>
                            <Menu.Item key="1">nav 1</Menu.Item>
                            <Menu.Item key="2">nav 2</Menu.Item>
                        </Menu>
                    </Col>
                </Row>
            </Header>
            <Content>
                <div {...contentProps}>
                    <Row {...rowProps}>
                        <Col {...colProps}>
                            <CurrentPage/>
                        </Col>
                    </Row>
                    <a href="https://www.freepik.com/free-photos-vectors/background">Background vector created by
                        freepik - www.freepik.com</a>
                </div>
            </Content>
            <Footer/>
        </Layout>
    );

}

export default App;