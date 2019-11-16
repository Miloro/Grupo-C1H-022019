import axios from "axios";

const axiosRequest = async (axiosRequest, getTokenSilently, manageResponse) => {
    const token = await getTokenSilently();
    try {
        const response = await axiosRequest("/api/private", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        });
        manageResponse(response);
    } catch (error) {
        console.error(error);
    }
};

export function get(getTokenSilently, manageResponse) {return axiosRequest(axios.get, getTokenSilently, manageResponse)}
export function post(getTokenSilently, manageResponse) {return axiosRequest(axios.post, getTokenSilently, manageResponse)}
export function put(getTokenSilently, manageResponse) {return axiosRequest(axios.put, getTokenSilently, manageResponse)}
