package Model;

import API.APIRequest;
import API.Response;
import Model.TypeModel.UserModel;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;


public class User extends Model {
    static String endpoint = "users";
    public UserModel model;

    public User(JSONObject jsonObject) {
        super.data = new UserModel(jsonObject);
        model = (UserModel) super.data;
    }

    public static void list(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.list(endpoint, data, header, response, User.class);
    }

    public static void show(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.show(endpoint, data, header, response, User.class);
    }

    public static void create(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.create(endpoint, data, header, response, User.class);
    }

    public static void delete(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.delete(endpoint, data, header, response, User.class);
    }

    public static void register(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        APIRequest.post("register", setData(data), setHeader(header), response, User.class);
    }
}
