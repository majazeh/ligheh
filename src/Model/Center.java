package Model;

import API.Response;
import Model.TypeModel.CenterModel;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Center extends Model {
    static String endpoint = "centers";
    public CenterModel model;

    public Center(JSONObject jsonObject) {
        super.data = new CenterModel(jsonObject);
        model = (CenterModel) super.data;
    }

    public static void list(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        try {
            Model.list(endpoint, data, header, response, Center.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(HashMap<String, Object> data, HashMap<String, Object> header, Response response)  {
        try {
            Model.show(endpoint, data, header, response, Center.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create(HashMap<String, Object> data, HashMap<String, Object> header, Response response)  {
        try {
            Model.create(endpoint, data, header, response, Center.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(HashMap<String, Object> data, HashMap<String, Object> header, Response response)  {
        try {
            Model.delete(endpoint, data, header, response, Center.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update(HashMap<String, Object> data, HashMap<String, Object> header, Response response) {
        try {
            Model.update(endpoint, data, header, response, Center.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
