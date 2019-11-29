import axios from "axios";

const autocompleteUrl = "https://autocomplete.geocoder.api.here.com/6.2/suggest.json";
const geocoderUrl = "https://geocoder.api.here.com/6.2/geocode.json";

const hereMapsParams = (data) => (
    {
        "params": {
            "app_id": process.env.REACT_APP_HERE_MAPS_ID,
            "app_code": process.env.REACT_APP_HERE_MAPS_CODE,
            ...data
        }
    }
);

const createLocation = response => {
    const location = response.data.Response.View[0].Result[0].Location;
    return {
        address: `${location.Address.Street} ${location.Address.HouseNumber}`,
        city: `${location.Address.City}`,
        latitude: location.DisplayPosition.Latitude,
        longitude: location.DisplayPosition.Longitude
    };
};

export const fetchSuggestions = async (query, then) => {
    try {
        const response = await axios.get(autocompleteUrl, hereMapsParams({"query": query, "maxresults": 5}));
        then(response);
    }
    catch (error) {
        console.error(error);
    }
};

export const fetchLocation = async (id, then) => {
    try {
        const response = await axios.get(geocoderUrl, hereMapsParams({"locationId": id}));
        then(createLocation(response));
    }
    catch (error) {
        console.error(error);
    }
};