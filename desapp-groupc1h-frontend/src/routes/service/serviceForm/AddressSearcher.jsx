import React from 'react';
import {Form, AutoComplete} from "formik-antd";
import {FormattedMessage, useIntl} from "react-intl";
import {message, Button, Col, Row} from "antd";
import {fetchSuggestions, fetchLocation} from "../../../api/hereMapsAPI";

const {Item} = Form;

function AddressSearcher({selected, suggestions, setFieldValue}) {
    const {formatMessage} = useIntl();

    // noinspection JSUnresolvedVariable,JSUnresolvedVariable
    const createSuggestion = (address, locationId) => ({
        id: locationId, address:
            `${address.street} ${address.houseNumber}, ${address.city}, ${address.state}`
    });

    const onSearch = query => {
        if (query.length > 10) {
            fetchSuggestions(query, (response) => {
                // noinspection JSUnresolvedVariable
                const suggestions = response.data.suggestions
                    .filter((s) => s.matchLevel === 'houseNumber')
                    .map((s) => (createSuggestion(s.address, s.locationId)));
                setFieldValue('suggestions', suggestions);
            })
        }
    };

    const onSelect = selected => {
        const selectedLocation = suggestions
            .find((l) => l.address === selected);
        setFieldValue('selected', selectedLocation);
    };

    const onClick = () => {
        fetchLocation(selected.id, (response) => {
            setFieldValue("location", response);
            message.success(formatMessage({id:"location.verified"}));
        });
    };

    return (
        <Item name="query">
            <Row gutter={[16, 16]}>
                <Col span={20}>
                    <AutoComplete
                        name="query"
                        dataSource={suggestions.map((s) => (s.address))}
                        onSearch={(query) => onSearch(query)}
                        onSelect={(selected) => onSelect(selected)}
                        placeholder={formatMessage({id: "address"})}
                    />
                </Col>
                <Col span={4}>
                    <Button
                        style={{marginRight: -12}}
                        size="large"
                        type="primary"
                        onClick={onClick}
                        disabled={!selected.id}
                    >
                        <FormattedMessage id="verified"/>
                    </Button>
                </Col>
            </Row>

        </Item>);

}

export default AddressSearcher;