package Model.TypeModel;

import Model.User;
import org.json.JSONObject;

public class AuthModel extends TypeModel{
    private String theory;
    private String key;
    private String callback;
    private String token;
    private User user;

    public AuthModel(JSONObject jsonObject) {
        if (!jsonObject.isNull("theory"))
            setTheory(jsonObject.getString("theory"));
        if (!jsonObject.isNull("key"))
            setKey(jsonObject.getString("key"));
        if (!jsonObject.isNull("callback"))
            setCallback(jsonObject.getString("callback"));
        if (!jsonObject.isNull("token"))
            setToken(jsonObject.getString("token"));
        if (!jsonObject.isNull("token"))
            setUser(new User(jsonObject));

    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  "theory='" + theory + '\'' +
                ", key='" + key + '\'' +
                ", callback='" + callback + '\'' +
                ", token='" + token + '\'' +
                ", user=" + user;
    }
}
