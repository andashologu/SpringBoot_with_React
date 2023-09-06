import http from "../http-common";

class ClientDataService {
    getAll() {
        return http.get("/getAll");
    }
    get(id) {
        return http.get(`/client/${id}`);
    }
    create(data) {
        return http.post("/add", data);
    }
}

export default new ClientDataService();