import axios from "axios";

const axiosRequest = async (method, url, data, getTokenSilently, then,
                            catchIt=(error) => (console.error(JSON.stringify(error)))) => {
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
        catchIt(error);
    }
};

export function get(getTokenSilently, url, then, catchIt) {
    return axiosRequest("get", url, {}, getTokenSilently, then, catchIt)
}
export function post(getTokenSilently, url, data, then, catchIt) {
    return axiosRequest("post", url, {data: data}, getTokenSilently, then, catchIt)
}
export function put(getTokenSilently, url, data, then, catchIt) {
    return axiosRequest("put", url, {data: data}, getTokenSilently, then, catchIt)
}