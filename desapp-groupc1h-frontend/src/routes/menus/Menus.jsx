import React, {useEffect, useState} from 'react';
import menu from "./mock-menu";
import MenuOrderRadio from "./list/MenuOrderRadio";
import MenuListItem from "./list/MenuListItem";
import {Col, Layout, List, Pagination, Radio, Row} from "antd";
import {useLocation} from "react-router-dom";
import {useIntl} from "react-intl";
import axios from "axios";

const {Header, Content} = Layout;
const {Group} = Radio;

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

function Menus(props) {
    let query = useQuery();
    const {formatMessage} = useIntl();
    const [layout, setLayout] = useState("list");
    const [page, setPage] = useState({
        current: 0,
        size: null,
    });
    const [search, setSearch] = useState({
        filterField: query.get("field"),
        filterQuery: query.get("q"),
        order: null
    });
    const [results, setResults] = useState(null);

    useEffect(() => {
        axios.post("api/menus", {pageSize: page.size, ...search})
            .then((response) => {
                setResults(response.data.content);
                setPage({
                    current: response.data.content.pageable.pageNumber,
                    size: response.data.content.pageable.pageSize
                });
            });
    });

    function MenuPagination() {
        return <Pagination
            current={page.current}
            pageSize={page.size}
            showTotal={(total, range) => `${range[0]}-${range[1]} of ${total} items`}
        />
    }

    function onLayoutChange(e) {
        setLayout(e.target.value);
    }

    function onOrderChange(e) {
        setSearch({
            ...search,
            order: e.target.value
        });
    }

    return (
        <Layout>
            <Header>
                <Row type="flex" justify="space-around" align="middle">
                    <Col span={14}> <MenuOrderRadio onChange={onOrderChange} value={search.order}/> </Col>
                    <Col span={6}>
                        <Group onChange={onLayoutChange} name="layout" buttonStyle="solid" value={layout}>
                            <Radio.Button value={"map"}>{formatMessage({id: "map"})}</Radio.Button>
                            <Radio.Button value={"list"}>{formatMessage({id: "list"})}</Radio.Button>
                        </Group>
                    </Col>
                </Row>
            </Header>
            <Content>
                <List
                    itemLayout="vertical"
                    bordered={true}
                    pagination={<MenuPagination/>}
                    dataSource={results}
                    renderItem={(item) => (<MenuListItem item={item}/>)}
                />
            </Content>
        </Layout>

    );
}

export default Menus;