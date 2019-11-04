import axios from 'axios';

export function GetMenu(idMenu){
    return axios.get('/menu/' + idMenu)
}