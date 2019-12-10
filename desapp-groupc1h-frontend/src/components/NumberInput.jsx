import React from 'react';
import {InputNumber} from "formik-antd";

const inputNumberProps = {
    style: {width: '100%'}
};

function NumberInput({name, placeholder}) {
    return (
        <InputNumber  min={0} type="number" name={name} {...inputNumberProps}
                     placeholder={placeholder}/>
    );
}

export default NumberInput;