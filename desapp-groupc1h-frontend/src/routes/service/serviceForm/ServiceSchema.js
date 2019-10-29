import * as Yup from 'yup';

function ServiceSchema(t) {

    return Yup.object().shape({
        name: Yup.string()
            .min(2, 'Too Short!')
            .max(50, 'Too Long!')
            .required(t.required),
        description: Yup.string()
            .min(30, 'Too Short!')
            .max(200, 'Too Long!')
            .required('Required'),
        eMail: Yup.string()
            .email('Invalid email')
            .required('Required'),
        website: Yup.string()
            .min(2, 'Too Short!')
            .max(50, 'Too Long!'),
        phoneNumber: Yup.number()
            .max(8, 'Too Long!')
            .required('Required'),
        timetable: Yup.array().of(Yup.object().shape({
            checked: Yup.boolean(),
            from: Yup.date(),
            to: Yup.date().when('from', (st, schema) => {
                return Yup.date().min(st);
            })
        })),
        query: Yup.string()
            .min(6, 'Too Short!')
            .required('Required'),
        selected: Yup.object().shape({
            id: Yup.string()
                .required('Select an address from the options'),
            address: Yup.string()
                .required('Required')
        })
    });
}


export default ServiceSchema;