import React, {useState} from 'react';
import {Input, Select} from 'antd';
import {FormattedMessage, useIntl} from "react-intl";
const InputGroup = Input.Group;
const { Search} = Input;
const {Option} = Select;

function SearchMenuInput() {
    const {formatMessage} = useIntl();
    const [selection, setSelection] = useState('city');
    const widthStyleProp = (w) => ({ style: {width: w}});

    function onSelect(selection) {
        setSelection(selection);
    }

    function onSearch(query) {
        console.log(query);
        console.log(selection);
    }

    return (
                <InputGroup compact size="large">
                    <Select defaultValue="city" onSelect={onSelect} {...widthStyleProp('15%')}>
                        {["city", "name", "category"].map ((s) =>(
                        <Option key={s} value={s}>
                            <FormattedMessage id={s}/>
                        </Option>
                        ))}
                    </Select>
                    <Search
                        placeholder={formatMessage({id:"searchMenu"})}
                        size="large"
                        {...widthStyleProp('70%')}
                        onSearch={onSearch}
                        enterButton
                    />
                </InputGroup>
    );
}

export default SearchMenuInput;