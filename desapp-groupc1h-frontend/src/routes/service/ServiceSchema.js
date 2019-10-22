import * as Yup from 'yup';

function ServiceSchema() {

    return Yup.object().shape({
        Name: Yup.string()
            .min(2, 'Too Short!')
            .max(50, 'Too Long!')
            .required('Required'),
        Description: Yup.string()
            .min(30, 'Too Short!')
            .max(200, 'Too Long!')
            .required('Required'),
        Email: Yup.string()
            .email('Invalid email')
            .required('Required'),
        WebSite: Yup.string()
            .min(2, 'Too Short!')
            .max(50, 'Too Long!'),
        PhoneNumber: Yup.number()
            .max(8, 'Too Long!')
            .required('Required'),
    });
}

export default ServiceSchema;