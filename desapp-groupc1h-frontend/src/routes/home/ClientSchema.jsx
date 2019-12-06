import * as Yup from 'yup';

const ClientSchema = formatMessage => {
    const regex = /^(?:(?:00)?549?)?0?(?:11|[2368]\d)(?:(?=\d{0,2}15)\d{2})??\d{8}$/;

    return Yup.object().shape({
        name: Yup.string()
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30}))
            .required(formatMessage({id: 'required'})),
        lastName: Yup.string()
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30}))
            .required(formatMessage({id: 'required'})),
        email: Yup.string()
            .email(formatMessage({id: 'invalidFormat'}))
            .required(formatMessage({id: 'required'})),
        phoneNumber: Yup.number()
            .typeError(formatMessage({id: 'required'}))
            .test('validFormatPhoneNumber', formatMessage({id: 'invalidFormat'}),
                (phoneNumber) => (phoneNumber === undefined ? true : phoneNumber.toString().match(regex)))
            .required(formatMessage({id: 'required'})),
        query: Yup.string()
            .min(10, formatMessage({id: 'string.min'}, {n: 10}))
            .required(formatMessage({id: 'required'})),
        selected: Yup.object().shape({
            id: Yup.string()
                .required(),
            address: Yup.string()
                .required(formatMessage({id: 'required'}))
        }),
        location: Yup.object()
            .required("formatMessage({id: 'required'})")
    })

};

export default ClientSchema;