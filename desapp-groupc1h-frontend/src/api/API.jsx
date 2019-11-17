import axios from "axios";

const axiosRequest = async (method, url, data, getTokenSilently, then) => {
    try {
        const token = await getTokenSilently();
        const response = await axios({
            method: method,
            url: url,
            ...data,
            headers: {
                Authorization: `Bearer ${token}`
            }
        });
        then(response);
    } catch (error) {
        console.error(JSON.stringify(error));
    }
};

export function get(getTokenSilently, url, then) {
    return axiosRequest("get", url, {}, getTokenSilently, then)
}
export function post(getTokenSilently, url, data, then) {
    return axiosRequest("post", url, {data: data}, getTokenSilently, then)
}
export function put(getTokenSilently, url, data, then) {
    return axiosRequest("put", url, {data: data}, getTokenSilently, then)
}