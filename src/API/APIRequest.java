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
    public static String baseUrl = "https://bapi.risloo.ir/api/";
    public APIRequest(API.Response callback, Class aClass, OkHttpClient client,Request request) {
        super(callback, aClass, client, request);
        request(callback, aClass, client, request);
    }
    static void exec(String endpoint, String method, RequestData data, RequestHeader headers, API.Response callback, Class aClass) throws IOException {
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
                APIRequest.ExternalAPIEvents.getDeclaredConstructor(API.Response.class,Class.class,OkHttpClient.class,Request.class).newInstance(callback,aClass,client,request);

            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }else {
            new APIRequest(callback,aClass,client,request);
        }

    }

    public static void get(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, Class aClass) throws IOException {
        exec(endpoint, "GET", data, header, response, aClass);
    }

    public static void post(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, Class aClass) throws IOException {
        exec(endpoint, "POST", data, header, response, aClass);
    }

    public static void delete(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, Class aClass) throws IOException {
        exec(endpoint, "DELETE", data, header, response, aClass);
    }

    public static void update(String endpoint, @Nullable RequestData data, RequestHeader header, API.Response response, Class aClass) throws IOException {
        exec(endpoint, "PUT", data, header, response, aClass);
    }

    @Override
    void onResponsed(API.Response callback,Object response,Class aClass) {
        if (response.getClass().getTypeName().equals("okhttp3.Response")) {
            try {
                JSONObject object = new JSONObject(((Response) response).body().string());
                Res res = new Res(object, aClass);
                callback.onOK(res.Build());
            } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(response);
        }
    }
}
