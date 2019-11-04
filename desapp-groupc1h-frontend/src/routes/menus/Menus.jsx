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

    const orders = {
        "lowestPrice": {field: "price", isAsc: true},
        "highestPrice": {field: "price", isAsc: false},
        "lowestRating": {field: "rating", isAsc: true},
        "highestRating": {field: "rating", isAsc: false}
    };

    const [layout, setLayout] = useState("list");
    const [search, setSearch] = useState({
        page: {current: 1, size: 20,},
        filter: {field: query.get("field"), q: query.get("q")},
        order: {field: "price", isAsc: true}
    });

    useEffect(() => {
        console.log(search);
    });


    function MenuPagination() {
        return <Pagination
            current={search.page.current}
            pageSize={search.page.size}
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
                    dataSource={[menu, menu, menu]}
                    renderItem={(item) => (<MenuListItem item={item}/>)}
                />
            </Content>
        </Layout>

    );
}

export default Menus;