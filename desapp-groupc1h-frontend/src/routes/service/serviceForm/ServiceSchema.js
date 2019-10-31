import * as Yup from 'yup';

function ServiceSchema(formatMessage) {
    const regex = /^(?:(?:00)?549?)?0?(?:11|[2368]\d)(?:(?=\d{0,2}15)\d{2})??\d{8}$/;

    return Yup.object().shape({
        name: Yup.string()
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30}))
            .required(formatMessage({id: 'required'})),
        description: Yup.string()
            .min(30, formatMessage({id: 'string.min'}, {n: 30}))
            .max(200, formatMessage({id: 'string.max'}, { n: 200}))
            .required(formatMessage({id: 'required'})),
        eMail: Yup.string()
            .email(formatMessage({id:'invalidFormat'}))
            .required(formatMessage({id: 'required'})),
        website: Yup.string()
            .url(formatMessage({id:'invalidFormat'}))
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30})),
        phoneNumber: Yup.number()
            .typeError(formatMessage({id:'required'}))
            .test('validFormatPhoneNumber', formatMessage({id:'invalidFormat'}),
                (phoneNumber) => (phoneNumber === undefined ? true : phoneNumber.toString().match(regex)))
            .required(formatMessage({id: 'required'})),
        query: Yup.string()
            .min(10, formatMessage({id: 'string.min'}, {field: 'Website', n: 10}))
            .required(formatMessage({id: 'required'}, {field: 'Adress'})),
        selected: Yup.object().shape({
            id: Yup.string()
                .required(),
            address: Yup.string()
                .required(formatMessage({id: 'required'}, {field: 'Adress'}))
        }),
        maxDistanceDeliveryInKms: Yup.number()
            .typeError(formatMessage({id:"num"}))
            .required(formatMessage({id: 'required'})),
    });
}


export default ServiceSchema;