import React, {useEffect, useState} from 'react';
import {Col, Layout, List, Pagination, Radio, Row} from "antd";
import {useLocation} from "react-router-dom";
import {useIntl} from "react-intl";
import axios from "axios";
import MenuItem from "./MenuItem";
import MenuMap from "./MenuMap";
import menu from "./mock-menu";

const {Header, Content, Footer} = Layout;
const {Group} = Radio;

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

function Menus(props) {
    let query = useQuery();
    const {formatMessage} = useIntl();

    const [order, setOrder] = useState(null);
    const filterField = query.get("field");
    const filterQuery = query.get("q");

    const pageSize = 20;
    const [pageCurrent, setPageCurrent] = useState(1);
    const [pageTotal, setPageTotal] = useState(null);

    const [results, setResults] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

    const [selectedMenuMap, setSelectedMenuMap] = useState(menu);
    const [isVisibleMenuMap, setIsVisibleMenuMap] = useState(false);

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

    const onOrderChange = e => {
        setOrder(e.target.value);
        setPageCurrent(1);
    };

    const onPageChange = (current) => {
        setPageCurrent(current);
    };

    const onOpenMenuMap = (item) => {
        setSelectedMenuMap(item);
        setIsVisibleMenuMap(true);
    };

    const onCloseMenuMap = () => {
      setSelectedMenuMap(menu);
      setIsVisibleMenuMap(false);
    };

    return (
        <Layout>
            <Header>
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={20}>
                        <Group onChange={onOrderChange} name="orders" size="large" value={order}>
                            <Radio value="lowestPrice">{formatMessage({id: "lowestPrice"})}</Radio>
                            <Radio value="highestPrice">{formatMessage({id: "highestPrice"})}</Radio>
                            <Radio value="lowestScore">{formatMessage({id: "lowestScore"})}</Radio>
                            <Radio value="highestScore">{formatMessage({id: "highestScore"})}</Radio>
                        </Group>
                    </Col>
                </Row>
            </Header>
            <Content>
                <List
                    itemLayout="vertical"
                    bordered={true}
                    dataSource={results}
                    renderItem={(item) => (<MenuItem item={item} onOpenMap={onOpenMenuMap}/>)}
                    loading={isLoading}
                    style={{minHeight: "400px"}}
                />
                <MenuMap item={selectedMenuMap} visible={isVisibleMenuMap} onClose={onCloseMenuMap}/>
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