import axios from "axios";

const REST_API_BASE_URL ='http://localhost:8080/api/users'

export const listUsers = () => axios.get(REST_API_BASE_URL);
export const createUser = (user) => axios.post(REST_API_BASE_URL, user);
export const getUser = (id) => axios.get(REST_API_BASE_URL+'/'+ id);
export const updateUser = (id, user) => axios.put(REST_API_BASE_URL+'/'+ id, user);
export const deleteUser = (id) => axios.delete(REST_API_BASE_URL+'/'+ id);
