package Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;

public class Res {
    private final JSONObject data;
    private final Class aClass;

    public Res(JSONObject data, Class aClass) {
        this.data = data;
        this.aClass = aClass;
    }

    public Object Build() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (!data.isNull("data")) {
            JSONObject jsonObject;
            switch (data.get("data").getClass().getName()) {
                case "org.json.JSONObject":
                    jsonObject = (JSONObject) data.get("data");
                    if (hasToken(data)) jsonObject.put("token", data.getString("token"));
                    return aClass.getDeclaredConstructor(JSONObject.class).newInstance(jsonObject);
                case "org.json.JSONArray":
                    JSONArray jsonArray = (JSONArray) data.get("data");
                    List list = new List();
                    list.setData(data);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        list.add((Model) aClass.getDeclaredConstructor(JSONObject.class).newInstance(jsonObject));
                    }
                    return list;
                default:
                    return data.get("data");
            }
        } else {
            return aClass.getDeclaredConstructor(JSONObject.class).newInstance(data);

        }
    }

    public boolean hasToken(JSONObject jsonObject) {
        return !jsonObject.isNull("token");
    }

}
