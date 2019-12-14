import React, {useEffect, useState} from 'react';
import {Col, Layout, List, Pagination, Radio, Row} from "antd";
import {useLocation} from "react-router-dom";
import {FormattedMessage, useIntl} from "react-intl";
import MenuItem from "./MenuItem";
import {useAPI} from "../../providers/ApiProvider";
const {Header, Content, Footer} = Layout;
const {Group} = Radio;

const useQuery = () => new URLSearchParams(useLocation().search);

const Menus = () => {
    let query = useQuery();
    const {formatMessage} = useIntl();
    const {searchMenus} = useAPI();

    const [order, setOrder] = useState(null);
    const filterField = query.get("field");
    const filterQuery = query.get("q");

    const pageSize = 2;
    const [pageCurrent, setPageCurrent] = useState(1);
    const [pageTotal, setPageTotal] = useState(null);

    const [results, setResults] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchMenus = () => {
            setIsLoading(true);
            const searchDTO = {
                filterField: filterField, filterQuery: filterQuery, order: order,
                pageCurrent: pageCurrent, pageSize: pageSize
            };
            searchMenus(searchDTO, (response) => {
                setResults(response.data.content);
                // noinspection JSUnresolvedVariable
                setPageTotal(response.data.totalElements);
                setIsLoading(false);
            });
        };
        fetchMenus();
        window.scrollTo(0, 0);
    }, [searchMenus, filterField, filterQuery, order, pageCurrent]);

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
                    <Col span={20}>
                        <FormattedMessage id="orderBy"/>
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
                    renderItem={(item) => (<MenuItem item={item}/>)}
                    loading={isLoading}
                    style={{minHeight: "400px"}}
                />
            </Content>
            <Footer>
                <Pagination defaultPageSize={pageSize}
                            total={pageTotal}
                            current={pageCurrent}
                            onChange={onPageChange}/>
            </Footer>
        </Layout>

    );
};

export default Menus;