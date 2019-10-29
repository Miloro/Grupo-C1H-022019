import * as Yup from 'yup';

function ServiceSchema(formatMessage) {

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
            .email(formatMessage({id:'invalid'}))
            .required(formatMessage({id: 'required'})),
        website: Yup.string()
            .url(formatMessage({id:'invalid'}))
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30})),
        phoneNumber: Yup.number()
            .typeError(formatMessage({id:"num"}))
            .min(8, formatMessage({id: 'num.min'}, {n: 8}))
            .required(formatMessage({id: 'required'})),
        timetable: Yup.array().of(Yup.object().shape({
            checked: Yup.boolean(),
            // from: Yup.date(),
            // to: Yup.date().when('from', (st, schema) => {
            //     return schema.min(st);
            // })
        })),
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