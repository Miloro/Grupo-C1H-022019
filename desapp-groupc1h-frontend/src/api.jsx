import axios from "axios";
import {post,put} from "./api/API";



export function GetMenu(idMenu){
    return axios.get("api/menu/" + idMenu);
}

export function createOrder(object,token,idMenu,userId){
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

    console.log(body)
    console.log("api/menu/"+idMenu+"/user/"+userId+"/order")
    return post(token,"api/menu/"+idMenu+"/user/"+userId+"/order",body,(res) => {
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
                return(res.data[month][day] === undefined);
            }
        })
        .catch((error) => {
            return(error);
        });
}

export function deposit(userId, amount, token){
    const body = {
        "amount" : amount
    };
    return put(token,"/api/user/"+userId+"/client", body).then(
        res => {
            if (res.status ===200){
                return res;
            }
        }
    ).catch((error) => {
        return error;
    });

}

export function withdraw(userId, amount,token){
    const body = {
        "amount" : amount
    };
    return put(token,"/api/user/"+userId+"/service", body).then(
        res => {
            if (res.status ===200){
                return res;
            }
        }
    ).catch((error) => {
        return error;
    });
}