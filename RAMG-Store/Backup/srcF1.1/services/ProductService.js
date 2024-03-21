import axios from "axios";
import { getToken } from "./AuthService";

const BASE_REST_API_URL = 'http://localhost:8080/api/products';

// export function getAllProducts(){
//     return axios.get(BASE_REST_API_URL);
// }

// Add a request interceptor
axios.interceptors.request.use(function (config) {
    
    config.headers['Authorization'] = getToken();

    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });
  
export const getAllProducts = () => axios.get(BASE_REST_API_URL)

export const saveProduct = (product) => axios.post(BASE_REST_API_URL, product)

export const getProduct = (id) => axios.get(BASE_REST_API_URL + '/' + id)

export const updateProduct = (id, product) => axios.put(BASE_REST_API_URL + '/' + id, product)

export const deleteProduct = (id) => axios.delete(BASE_REST_API_URL + '/' + id)

export const getAllProductsByUserId = (userId) => axios.get(BASE_REST_API_URL+'/user/'+userId)

// export const updateQuantity = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/quantity')

// export const completeProduct = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/complete')

// export const inCompleteProduct = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/in-complete')