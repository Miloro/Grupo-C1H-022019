import React from "react";
import axios from 'axios';
import {Formik} from "formik";
import {Col, Row} from "antd";
import {Form, AutoComplete} from "@jbuschke/formik-antd";

const {Item} = Form;

function AdressSearcher() {

    function onSubmit() {

    }


    function formatAdress(address, id) {
        return `${address.street} ${address.houseNumber},  ${address.city}, ${address.state}`;
    }

    function onSearch(query, setFieldValue) {
        if (query.length > 6) {
            axios.get('https://autocomplete.geocoder.api.here.com/6.2/suggest.json', {
                'params': {
                    'app_id': 'B3ZYLI1mKHNO6Qt871t6',
                    'app_code': 'xibhrih8Kcvp0bcijbEBqA',
                    'query': query,
                    'maxresults': 4,
                }
            }).then((response) => {
                const formattedAddresses = response.data.suggestions
                    .map((s) => (formatAdress(s.address, s.locationId)));
                setFieldValue('dataSource', formattedAddresses);
            });
        }
    }

    function exampleForm(props) {
        const {values, setFieldValue} = props;
        return <Form>
            <Item name="query">
                <AutoComplete
                    name="query"
                    dataSource={values.dataSource}
                    onSearch={(query) => onSearch(query, setFieldValue)}
                    style={{width: '180%'}}
                    placeholder="Street Number City"
                />
            </Item>
        </Form>
    }

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col >
                <Formik
                    initialValues={{query: '', dataSource: []}}
                    onSubmit={onSubmit}
                    component={exampleForm}
                />
            </Col>
        </Row>

    );

}

export default AdressSearcher;