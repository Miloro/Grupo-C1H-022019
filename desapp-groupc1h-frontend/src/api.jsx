import axios from "axios";

export function GetMenu(idMenu){
    return axios.get("api/menu/" + idMenu);
}

export function createOrder(object){
    const body = {
        "amount" : object.amount,
        "offers" : [],
        "state" : "PENDING",
        "delivery" : object.delivery,
        "orderDate": {
                    "from":object.date+ "T" + object.orderTimeFrom,
                    "to": object.date+ "T" + object.orderTimeTo
                    }
    };
    return axios.post("api/menu/13/client/22/order",body).then(
        (res) => {
            if (res.status === 200){
                console.log(res);
            }
        })
        .catch((error) => {
            console.log(error);
        });
}

export function isNotHoliday(day, month, year){
    const res = axios.get("http://nolaborables.com.ar/api/v2/feriados/"+year+"?formato=mensual").then(
        res => {
            if (res.status === 200){
                console.log(res.data[month][day] === undefined);
            }
        })
        .catch((error) => {
            console.log(error);
        });
}