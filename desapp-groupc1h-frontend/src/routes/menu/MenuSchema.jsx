import * as Yup from 'yup';

const MenuSchema = formatMessage =>
    Yup.object().shape({
        name: Yup.string()
            .min(2, formatMessage({id: 'string.min'}, {n: 2}))
            .max(30, formatMessage({id: 'string.max'}, {n: 30}))
            .required(formatMessage({id: 'required'})),
        description: Yup.string()
            .min(20, formatMessage({id: 'string.min'}, {n: 20}))
            .max(400, formatMessage({id: 'string.max'}, {n: 400}))
            .required(formatMessage({id: 'required'})),
        categories: Yup.array()
            .min(1, formatMessage({id: 'minOneSelected'})),
        cookingTime: Yup.number()
            .typeError(formatMessage({id: 'required'})),
        deliveryInfo: Yup.object().shape({
            price: Yup.number()
                .typeError(formatMessage({id: 'required'}))
                .min(10, formatMessage({id: 'num.min'}, {n: 10}))
                .max(40, formatMessage({id: 'num.max'}, {n: 40})),
            averageTime: Yup.number()
                .typeError(formatMessage({id: 'required'}))
                .min(5, formatMessage({id: 'num.min'}, {n: 5}))
                .max(120, formatMessage({id: 'num.max'}, {n: 120}))
        }),
        price: Yup.number()
            .typeError(formatMessage({id: 'required'}))
            .max(1000, formatMessage({id: 'num.max'}, {n: 1000})),
        maxAmountPerDay: Yup.number()
            .typeError(formatMessage({id: 'required'})),
        offers: Yup.object().shape({
            ls: Yup.array().min(2, formatMessage({id: 'minTwoCreated'}))
        }),
    });

export default MenuSchema;