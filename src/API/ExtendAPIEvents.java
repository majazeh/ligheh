package API;

import Model.Res;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ExtendAPIEvents extends APIEvents{

    public ExtendAPIEvents(Response callback, Class aClass, OkHttpClient client, Request request) {
        super(callback, aClass, client, request);
    }

    @Override
    <T> void onResponsed(Response callback, Object response, T t) {
        if (response.getClass().getTypeName().equals("okhttp3.Response")) {
            try {
                JSONObject object = new JSONObject(((okhttp3.Response) response).body().string());
                Res res = new Res(object, t);
                callback.onOK(res.Build());
            } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(response);
        }
    }
}
