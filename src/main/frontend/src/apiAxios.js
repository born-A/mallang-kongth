import axios, {AxiosResponse} from "axios";

export default function apiAxios(url, callback) {
    axios({
        url: '/' + url,
        method: 'post',
        baseURL: 'http://localhost:8080',
        withCredentials: false,
    }).then(function(response: AxiosResponse<>) {
        callback(response.data);
    });
}