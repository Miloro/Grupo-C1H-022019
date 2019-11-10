import React from 'react';
import {Form, AutoComplete} from "formik-antd";
import axios from "axios";
import {useIntl} from "react-intl";
const {Item} = Form;

function AddressSearcher({suggestions, setFieldValue}) {
    const {formatMessage} = useIntl();
    const url = 'https://autocomplete.geocoder.api.here.com/6.2/suggest.json';

    const createSuggestion = (address, locationId) => ({
        id: locationId, address:
            `${address.street} ${address.houseNumber}, ${address.city}, ${address.state}`
    });

    const createParams = query => ({
        'params': {
            'app_id': 'B3ZYLI1mKHNO6Qt871t6',
            'app_code': 'xibhrih8Kcvp0bcijbEBqA',
            'query': query,
            'maxresults': 5,
        }
    });

    const onSearch = query => {
        if (query.length > 10) {
            axios.get(url, createParams(query)).then((response) => {
                // noinspection JSUnresolvedVariable
                const suggestions = response.data.suggestions
                    .filter((s) => s.matchLevel === 'houseNumber')
                    .map((s) => (createSuggestion(s.address, s.locationId)));
                setFieldValue('suggestions', suggestions);
            });
        }
    };

    const onSelect = selected => {
        const selectedLocation = suggestions
            .find((l) => l.address === selected);
        setFieldValue('selected', selectedLocation);
    };

    return (
        <Item name="query">
            <AutoComplete
                name="query"
                dataSource={suggestions.map((s) => (s.address))}
                onSearch={(query) => onSearch(query)}
                onSelect={(selected) => onSelect(selected)}
                placeholder={formatMessage({id:"address"})}
            />
        </Item>);

}

export default AddressSearcher;