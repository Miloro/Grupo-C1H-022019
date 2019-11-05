import axios from 'axios';

export function GetMenu(idMenu){
    return axios.get('/menu/' + idMenu)
}

export function CreateOrder(){
    return axios.post("/order/menu/13/client/22",
    {
	    "amount" : 100,
        "offers" : [],
        "state" : "PENDING",
        "delivery" : true,
		"orderDate": {
					"from":"2019-01-25T21:34:55",
					"to":"2019-01-25T23:34:55" 
	            	}
    }
    )
}