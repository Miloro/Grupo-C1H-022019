import React, {useEffect, useState} from 'react';
import {Col, Layout, Pagination, Radio, Row} from "antd";
import {useLocation} from "react-router-dom";
import {useIntl} from "react-intl";
import axios from "axios";
import MenuList from "./list/MenuList";

const {Header, Content, Footer} = Layout;
const {Group} = Radio;

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

function Menus(props) {
    let query = useQuery();
    const {formatMessage} = useIntl();

    const pageSize = 5;
    const [layout, setLayout] = useState("list");

    const [order, setOrder] = useState(null);
    const filterField = query.get("field");
    const filterQuery = query.get("q");

    const [pageCurrent, setPageCurrent] = useState(1);
    const [pageTotal, setPageTotal] = useState(null);

    const [results, setResults] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchMenus = async () => {
            setIsLoading(true);
            const searchDTO = {
                filterField: filterField, filterQuery: filterQuery, order: order,
                pageCurrent: pageCurrent, pageSize: pageSize
            };
            const response = await axios.post("/api/menus/search", searchDTO);
            setResults(response.data.content);
            setPageTotal(response.data.totalElements);
            setIsLoading(false);
        };
        fetchMenus();
        window.scrollTo(0, 0);
    }, [filterField, filterQuery, order, pageCurrent]);


    const onLayoutChange = e => {
        setLayout(e.target.value);
    };

    const onOrderChange = e => {
        setOrder(e.target.value);
        setPageCurrent(1);
    };

    const onPageChange = (current) => {
        setPageCurrent(current);
    };


    return (
        <Layout>
            <Header>
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={14}>
                        <Group onChange={onOrderChange} name="orders" size="large" value={order}>
                            <Radio value="lowestPrice">{formatMessage({id: "lowestPrice"})}</Radio>
                            <Radio value="highestPrice">{formatMessage({id: "highestPrice"})}</Radio>
                            <Radio value="lowestScore">{formatMessage({id: "lowestScore"})}</Radio>
                            <Radio value="highestScore">{formatMessage({id: "highestScore"})}</Radio>
                        </Group>
                    </Col>
                    <Col span={6}>
                        <Group onChange={onLayoutChange} name="layout" buttonStyle="solid" value={layout}>
                            <Radio.Button value={"map"}>{formatMessage({id: "map"})}</Radio.Button>
                            <Radio.Button value={"list"}>{formatMessage({id: "list"})}</Radio.Button>
                        </Group>
                    </Col>
                </Row>
            </Header>
            <Content>
                <MenuList dataSource={results} isLoading={isLoading}/>
            </Content>
            <Footer>
                <Pagination defaultPageSize={pageSize}
                            total={pageTotal}
                            current={pageCurrent}
                            onChange={onPageChange}/>
            </Footer>
        </Layout>

    );
}

export default Menus;