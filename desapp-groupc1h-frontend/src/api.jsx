import axios from "axios";
import {post} from "./api/API";


export function GetMenu(idMenu){
    return axios.get("api/menu/" + idMenu);
}

export function createOrder(object,token){
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

    return post(token,"api/menu/11/client/9/order",body,(res) => {
        if (res.status === 200){
            console.log(res);
        }
    },(error) => {
        console.log(error);
    });
}

export function isNotHoliday(day, month, year){
    return axios.get("http://nolaborables.com.ar/api/v2/feriados/"+year+"?formato=mensual").then(
        res => {
            if (res.status === 200){
                console.log(res.data[month][day] === undefined);
            }
        })
        .catch((error) => {
            console.log(error);
        });
}

export function deposit(userId, amount){
    const body = {
        "amount" : amount
    };
    return axios.put("/api/user/"+userId+"/client", body).then(
        res =>{
            if (res.status ===200){
                return res;
            }
        }
    ).catch((error) => {
        return error;
    });

}

export function withdraw(userId, amount){
    const body = {
        "amount" : amount
    };
    return axios.put("/api/user/"+userId+"/service", body).then(
        res => {
            if (res.status ===200){
                return res;
            }
        }
    ).catch((error) => {
        return error;
    });
}