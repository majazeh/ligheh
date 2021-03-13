package Model;

import API.*;
import Model.TypeModel.TypeModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Model {
    public TypeModel data;



    public static void changeBaseUrl(String newBaseUrl) {
        APIRequest.baseUrl = newBaseUrl;
    }

    public static void show(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        if (data.containsKey("id")) {
            String id = (String) data.get("id");
            data.remove("id");
            APIRequest.get(endpoint + "/" + id, setData(data), setHeader(header), response, aClass);
        } else {
            Exceptioner.make("آیدی را وارد کنید");
        }
    }

    public static void list(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        APIRequest.get(endpoint, setData(data), setHeader(header), response, aClass);
    }

    public static void create(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        APIRequest.post(endpoint, setData(data), setHeader(header), response, aClass);
    }

    public static void delete(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        APIRequest.delete(endpoint, setData(data), setHeader(header), response, aClass);
    }

    public static void update(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        APIRequest.update(endpoint, setData(data), setHeader(header), response, aClass);
    }

    public static void post(String endpoint, HashMap<String, Object> data, HashMap<String, Object> header, Response response, Class aClass) throws IOException {
        APIRequest.post(endpoint, setData(data), setHeader(header), response, aClass);
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