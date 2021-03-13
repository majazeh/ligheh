package Model;

import API.APIRequest;
import API.Exceptioner;
import API.Response;
import Model.TypeModel.AuthModel;
import Model.TypeModel.CenterModel;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Auth extends Model {
    static String endpoint = "auth";
    public AuthModel model;

    public Auth(JSONObject jsonObject) {
        super.data = new AuthModel(jsonObject);
        model = (AuthModel) super.data;
    }

    public static void auth(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        try {
            Model.post(endpoint, data, header, response, Auth.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void auth_theory(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        try {
            if (data.containsKey("key")) {
                String key = (String) data.get("key");
                data.remove("key");
                Model.post(endpoint + "/theory" + "/" + key, data, header, response, Auth.class);
            } else {
                Exceptioner.make("آیدی را وارد کنید");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void register(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        if (!data.containsKey("mobile"))
            Exceptioner.make("شماره موبایل الزامی است");
        else {
            try {
                Model.create("register", data, header, response, Auth.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void verification(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        if (!data.containsKey("mobile"))
            Exceptioner.make("شماره موبایل الزامی است");
        else {
            try {
                Model.post("verification", data, header, response, Auth.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void recovery(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        if (!data.containsKey("mobile"))
            Exceptioner.make("شماره موبایل الزامی است");
        else {
            try {
                Model.post("recovery", data, header, response, Auth.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void logout(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
            if (!header.containsKey("Authorization"))
                Exceptioner.make("شما لاگین نیستید!");
            else {
        try {
                Model.post("logout", data, header, response, Auth.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
            }
    }
}
