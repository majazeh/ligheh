package API;

import Model.Res;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class APIEvents {
    public <T> APIEvents(API.Response callback, T t, OkHttpClient client, Request request) {

    }

    public APIEvents() {
    }

    public <T> void request(API.Response callback, T t, OkHttpClient client, Request request) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Exceptioner.make(e);
            }

            @Override
            public void onResponse(okhttp3.Response response) {
                try {
                    if (response.isSuccessful()) {
                        onResponsed(callback, response, t);
                    } else {
                        Exceptioner.make(response);
                    }
                } catch (JSONException e) {
                    Exceptioner.make(e);
                }
            }

        });
    }

    abstract <T> void onResponsed(API.Response callback, Object response, T aClass);
}
