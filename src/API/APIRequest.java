package API;

import Model.Res;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;


public class APIRequest extends APIEvents {
    public static Class ExternalAPIEvents;
    public static String baseUrl = "";
    public <T> APIRequest(API.Response callback, T t, OkHttpClient client, Request request) {
        super(callback, t, client, request);
        request(callback, t, client, request);
    }

    public APIRequest() {
        super();
    }

    <T> void exec(String endpoint, String method, RequestData data, RequestHeader headers, API.Response callback, T t) throws IOException {
        Request.Builder builder = new Request.Builder();
        String url = baseUrl + endpoint;

        Request request;

        if (method.equals("GET") || method.equals("DELETE")) {
            url = data.body(url);
            builder.method(method, null);
        } else if (method.equals("POST") || method.equals("PUT")) {
            builder.method(method, data.body());
        }
        builder.url(url);

        builder.headers(headers.headersBody());
        request = builder.build();
        OkHttpClient client;
        OkHttpClient.Builder builder1 = new OkHttpClient.Builder();
        builder1.connectTimeout(30, TimeUnit.SECONDS);
        builder1.readTimeout(30, TimeUnit.SECONDS);
        builder1.writeTimeout(30, TimeUnit.SECONDS);
        client = builder1.build();
        System.out.println(request.url());
        if (APIRequest.ExternalAPIEvents!=null){
            try {
                APIRequest.ExternalAPIEvents.getDeclaredConstructor(API.Response.class,Class.class,OkHttpClient.class,Request.class).newInstance(callback,t,client,request);

            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            new APIRequest(callback,t,client,request);
        }

    }

    public <T> void get(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, T t) throws IOException {
        exec(endpoint, "GET", data, header, response, t);
    }

    public  <T> void post(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, T t) throws IOException {
        exec(endpoint, "POST", data, header, response, t);
    }

    public  <T> void delete(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, T t) throws IOException {
        exec(endpoint, "DELETE", data, header, response, t);
    }

    public  <T> void update(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, T t) throws IOException {
        exec(endpoint, "PUT", data, header, response, t);
    }

    @Override
    <T> void onResponsed(API.Response callback, Object response, T t) {
        if (response.getClass().getTypeName().equals("okhttp3.Response")) {
            try {
                JSONObject object = new JSONObject(((Response) response).body().string());
                Res<T> res = new Res(object, t);
                callback.onOK(res.Build());
            } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(response);
        }
    }

}
