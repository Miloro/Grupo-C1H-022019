import React from "react";
import axios from 'axios';
import {Formik} from "formik";
import {Col, Row} from "antd";
import {Form, AutoComplete, SubmitButton} from "@jbuschke/formik-antd";
import * as Yup from 'yup';

const {Item} = Form;

function AdressSearcher() {

    function onSubmit(values) {
        axios.get('https://geocoder.api.here.com/6.2/geocode.json', {
            'params': {
                'app_id': 'B3ZYLI1mKHNO6Qt871t6',
                'app_code': 'xibhrih8Kcvp0bcijbEBqA',
                'locationId': values.selected.id
            }
        }).then((response) => {
            const checkedLocation = response.data.Response.View[0].Result[0].Location;
            const location = {
                address:  values.selected.address,
                coords: {
                    'lat': checkedLocation.DisplayPosition.Latitude,
                    'lon': checkedLocation.DisplayPosition.Longitude
                }
            };
            alert(JSON.stringify(location, null, 2));
        });
    }

    function createLocation(address, locationId) {
        return {
            id: locationId, address:
                `${address.street} ${address.houseNumber}, ${address.city}, ${address.state}`
        };
    }

    function onSearch(query, setFieldValue) {
        if (query.length > 6) {
            axios.get('https://autocomplete.geocoder.api.here.com/6.2/suggest.json', {
                'params': {
                    'app_id': 'B3ZYLI1mKHNO6Qt871t6',
                    'app_code': 'xibhrih8Kcvp0bcijbEBqA',
                    'query': query,
                    'maxresults': 5,
                }
            }).then((response) => {
                const suggestions = response.data.suggestions
                    .filter((s) => s.matchLevel === 'houseNumber')
                    .map((s) => (createLocation(s.address, s.locationId)));
                setFieldValue('suggestions', suggestions);
            });
        }
    }

    function onSelect(selected, setFieldValue, suggestions) {
        const selectedLocation = suggestions.find((l) => l.address === selected);
        setFieldValue('selected', selectedLocation);
    }

    function renderSuggestions(locations) {
        return locations.map((location) => (location.address));
    }

    function AdressAutocomplete(suggestions, setFieldValue) {
        return <Item name="query">
            <AutoComplete
                name="query"
                dataSource={renderSuggestions(suggestions)}
                onSearch={(query) => onSearch(query, setFieldValue)}
                onSelect={(selected) => onSelect(selected, setFieldValue, suggestions)}
                style={{width: '180%'}}
                placeholder="Street Number City"
            />
        </Item>
    }

    function exampleForm(props) {
        const {values, setFieldValue} = props;
        return <Form>
            {AdressAutocomplete(values.suggestions, setFieldValue)}
            <SubmitButton size='large' type='primary'> Submit </SubmitButton>
        </Form>
    }

    return (
        <Row type="flex" justify="space-around" align="middle">
            <Col>
                <Formik
                    initialValues={{query: '', selected: {id: '', address: ''}, suggestions: []}}
                    onSubmit={onSubmit}
                    component={exampleForm}
                    validationSchema={Yup.object().shape({
                        query: Yup.string()
                            .min(6, 'Too Short!')
                            .required('Required'),
                        selected: Yup.object().shape({
                            id: Yup.string()
                                .required('Select an address from the options'),
                            address: Yup.string()
                                .required('Required')
                        })
                    })}
                />
            </Col>
        </Row>

    );

}

export default AdressSearcher;