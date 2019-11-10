import React, {useState} from 'react';
import {Input, Select} from 'antd';
import {FormattedMessage, useIntl} from "react-intl";
import { useHistory } from "react-router-dom";
const InputGroup = Input.Group;
const {Search} = Input;
const {Option} = Select;

const MenuSearchInput = () => {
    const {formatMessage} = useIntl();
    const [selection, setSelection] = useState('city');
    const widthStyleProp = (w) => ({style: {width: w}});
    let history = useHistory();


    const onSelect = selection => {
        setSelection(selection);
    };

    const onSearch = query => {
        if(query !== undefined) {
            history.push(`/menus/search?field=${selection}&q=${query}`);
        }
    };

    return (
        <InputGroup compact size="large">
            <Select defaultValue="city" onSelect={onSelect} {...widthStyleProp('15%')}>
                {["city", "name"].map((s) => (
                    <Option key={s} value={s}>
                        <FormattedMessage id={s}/>
                    </Option>
                ))}
            </Select>
            <Search
                placeholder={formatMessage({id: "searchMenu"})}
                size="large"
                {...widthStyleProp('70%')}
                onSearch={onSearch}
                enterButton
            />
        </InputGroup>
    );
};

export default MenuSearchInput;