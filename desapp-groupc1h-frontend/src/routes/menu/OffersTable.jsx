import React from 'react';
import {FormattedMessage, useIntl} from "react-intl";
import {Button, Col, Row, Table, Typography} from "antd";
import PriceInput from "./PriceInput";
import {InputNumber, Form} from "formik-antd";

const {Paragraph, Title} = Typography;
const {Column} = Table;
const {Item} = Form;

const inputNumberProps = {
    style: {width: '100%'}
};

function OffersTable({offers, addOffer, deleteOfferButton}) {
    const {formatMessage} = useIntl();

    return ( <div>
            <Title level={4} className='align-left'>
                <FormattedMessage id="offer"/>
            </Title>
            <Paragraph>
                <FormattedMessage id="offerDisclaimer"/>
            </Paragraph>
            <Row gutter={[16, 16]}>
                <Col span={10}>
                    <Item name="offers.price">
                        <PriceInput name="offers.price"/>
                    </Item>
                </Col>
                <Col span={10}>
                    <Item name="offers.minAmount">
                        <InputNumber type="number"
                                     name="offers.minAmount" {...inputNumberProps}
                                     placeholder={formatMessage({id: "minAmount"})}/>
                    </Item>
                </Col>
                <Col span={4}>
                    <Button type="primary" onClick={addOffer}
                            disabled={!(offers.price && offers.minAmount)}>
                        <FormattedMessage id="add"/>
                    </Button>
                </Col>
                <Col span={24}>
                    <Table dataSource={offers.ls} pagination={false}>
                        <Column title={formatMessage({id: "price"})} dataIndex="price" key="price"/>
                        <Column title={formatMessage({id: "minAmount"})} dataIndex="minAmount"
                                key="minAmount"/>
                        <Column title={formatMessage({id: "delete"})} dataIndex="delete"
                                render={deleteOfferButton}/>
                    </Table>
                </Col>
            </Row>
        </div>
    );
}

export default OffersTable;