package Model;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class Res<T> {
    private final JSONObject data;
    private final T t;

    public Res(JSONObject data, T t) {
        this.data = data;
        this.t = t;
    }

    public <T> T Build() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println(data);
        if (!data.isNull("data")) {
            JSONObject jsonObject;
            switch (data.get("data").getClass().getName()) {
                case "org.json.JSONObject":
                    jsonObject = (JSONObject) data.get("data");
                    if (hasToken(data)) jsonObject.put("token", data.getString("token"));
                    return  new Gson().fromJson(String.valueOf(jsonObject), (Type) t.getClass());
                case "org.json.JSONArray":
                    JSONArray jsonArray = (JSONArray) data.get("data");
                    List list = new List();
                    list.setData(data);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        list.add((Model) t.getClass().getDeclaredConstructor(JSONObject.class).newInstance(jsonObject));
                    }
                    return (T) list;
                default:
                    return (T) data.get("data");
            }
        } else {
            try {
                return  new Gson().fromJson(String.valueOf(data), (Type) t.getClass());
            }catch (NullPointerException e){
                return (T) t.getClass().getDeclaredConstructor();
            }

        }
    }

    public boolean hasToken(JSONObject jsonObject) {
        return !jsonObject.isNull("token");
    }

}
