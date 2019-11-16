import axios from "axios";

const axiosRequest = async (customAxios, url, data, getTokenSilently, then) => {
    const token = await getTokenSilently();
    try {
        const response = await customAxios(url, {
            headers: {
                Authorization: `Bearer ${token}`
            },
            ...data
        });
        then(response);
    } catch (error) {
        console.error(error);
    }
};

export function get(getTokenSilently, url, then) {
    return axiosRequest(axios.get, url, {}, getTokenSilently, then)
}
export function post(getTokenSilently, url, data, then) {
    return axiosRequest(axios.post, url,{data: {...data}}, getTokenSilently, then)
}
export function put(getTokenSilently, url, data, then) {
    return axiosRequest(axios.post, url,{data: {...data}}, getTokenSilently, then)
}