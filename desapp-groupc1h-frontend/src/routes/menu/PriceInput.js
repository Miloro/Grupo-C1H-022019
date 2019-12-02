import React from 'react';
import {InputNumber} from "formik-antd";
import {useIntl} from "react-intl";

const inputNumberProps = {
    style: {width: '100%'}
};

function PriceInput({name}) {
    const {formatMessage} = useIntl();
    return (
        <InputNumber name={name} {...inputNumberProps}
                     decimalSeparator={formatMessage({id: "decimalSeparator"})}
                     formatter={value => `$${value}`}
                     parser={value => value.replace("$", "")}/>
    );
}

export default PriceInput;