import axios from 'axios';

const fetchClient = () => {

    let instance = axios.create({
        timeout: 10 * 60 * 1000,
    });

    function extracted(config) {
        config.headers["Access-Control-Allow-Headers"] ="X-Requested-With,content-type";
        config.headers["Access-Control-Allow-Origin"]= "*"; 
        config.headers["Access-Control-Allow-Methods"]= "GET, POST, OPTIONS, PUT, PATCH, DELETE"; 
        config.headers["Access-Control-Allow-Credentials"]= true; 
    }

    instance.interceptors.request.use(config => {
        extracted(config);
        return config;
    });

    return instance;
};

const client = fetchClient();


export default client;