package Model;

import API.*;
import Model.TypeModel.TypeModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Model<T> {
    public T t;
    public TypeModel data;

    public Model(T t) {
            this.t = t;
    }

    public void changeBaseUrl(String newBaseUrl) {
        APIRequest.baseUrl = newBaseUrl;
    }

    public void show(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.get(endpoint, setData(data), setHeader(header), response, t);
    }

    public  void list(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header,  Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.get(endpoint, setData(data), setHeader(header), response, t);
    }

    public  void create(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header,  Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.post(endpoint, setData(data), setHeader(header), response, t);
    }

    public  void delete(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header,  Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.delete(endpoint, setData(data), setHeader(header), response, t);
    }

    public  void update(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header,  Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.update(endpoint, setData(data), setHeader(header), response, t);
    }

    public  void post(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header,  Response<T> response) throws IOException {
        APIRequest apiRequest = new APIRequest();
        apiRequest.post(endpoint, setData(data), setHeader(header), response, t);
    }

    public static RequestData setData(HashMap<String, Object> data) {
        RequestData requestData = new RequestData();
        for (String key : data.keySet()) {
            requestData.set(key, data.get(key));
        }
        return requestData;
    }

    public static RequestHeader setHeader(HashMap<String, Object> header) {
        RequestHeader requestHeader = new RequestHeader();
        for (String key : header.keySet()) {
            requestHeader.set(key, header.get(key));
        }
        return requestHeader;
    }

}