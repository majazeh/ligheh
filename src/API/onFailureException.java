package API;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.Response;

abstract class onFailureException {
    String body;
    int statusCode;
    String message_text;
    String MESSAGE_TEXT;

    public onFailureException(Object object) {
        switch (object.getClass().getName()) {
            case "java.io.IOException":
            case "JSONException":
            case "IllegalAccessException":
            case "InstantiationException":
            case "java.net.SocketTimeoutException":
            case "NoSuchMethodException":
            case "InvocationTargetException":
                onClient(object);
                statusCode = 100;
                break;
            case "java.lang.String":
                onClient(object);
                break;
            case "okhttp3.Response":
                try {
                Response response = (Response) object;
                body = response.body().string();
                statusCode = response.code();
                        if (statusCode == 401){
                            // delete token
                        }

                    if (isJSONObject((body))) {
                        JSONObject jsonObject = new JSONObject(body);
                        message_text = jsonObject.getString("message_text");
                        MESSAGE_TEXT = jsonObject.getString("message");
                    onServerFail(jsonObject.getString("message_text"));

                        if (hasValidation(jsonObject)){
                            validation(jsonObject);
                        }
                    }else{
                        onServerFail(body);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
        }
    }

    public boolean hasValidation(JSONObject response) {
            return !response.isNull("errors");
    }

    public boolean isJSONObject(String string) {
        return string.startsWith("{") && string.endsWith("}");
    }

    public void validation(JSONObject response) {
            HashMap<String, Object> validationData = new HashMap<>();
                Iterator<String> keys = (response.getJSONObject("errors").keys());
                while (keys.hasNext()) {
                    String key = keys.next();
                    for (int i = 0; i < response.getJSONObject("errors").getJSONArray(key).length(); i++) {
                        validationData.put(key, response.getJSONObject("errors").getJSONArray(key).get(i));
                    }
                }
                onValidation(validationData);
    }

    abstract void onValidation(HashMap<String, Object> object);

    abstract void onClient(Object object);

    abstract void onServerFail(Object object);

    abstract void onAuth(Object object);
}
