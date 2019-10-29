import React from 'react';
import {Form, AutoComplete, Input} from "@jbuschke/formik-antd";
import axios from "axios";
const {Item} = Form;

function AddressSearcher({suggestions, setFieldValue}) {
    const url = 'https://autocomplete.geocoder.api.here.com/6.2/suggest.json';

    function renderSuggestions() {
        return suggestions.map((s) => (s.address));
    }

    function createLocation(address, locationId) {
        return {
            id: locationId, address:
                `${address.street} ${address.houseNumber}, ${address.city}, ${address.state}`
        };
    }

    function createParams(query) {
        return {
            'params': {
                'app_id': 'B3ZYLI1mKHNO6Qt871t6',
                'app_code': 'xibhrih8Kcvp0bcijbEBqA',
                'query': query,
                'maxresults': 5,
            }
        };
    }

    function onSearch(query) {
        if (query.length > 10) {
            axios.get(url, createParams(query)).then((response) => {
                const suggestions = response.data.suggestions
                    .filter((s) => s.matchLevel === 'houseNumber')
                    .map((s) => (createLocation(s.address, s.locationId)));
                setFieldValue('suggestions', suggestions);
            });
        }
    }

    function onSelect(selected) {
        const selectedLocation = suggestions
            .find((l) => l.address === selected);
        setFieldValue('selected', selectedLocation);
    }

    return (
        <div>
        <Item name="query">
            <AutoComplete
                name="query"
                dataSource={renderSuggestions}
                onSearch={(query) => onSearch(query)}
                onSelect={(selected) => onSelect(selected)}
                placeholder="Street Number City"
            />
        </Item>
            <Item name="maxDistanceDeliveryInKms">
                <Input name="maxDistanceDeliveryInKms" placeholder="Maximum distance to make a delivery in Kms*"/>
            </Item>
        </div>);

}

export default AddressSearcher;