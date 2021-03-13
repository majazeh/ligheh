package Model;

import API.Response;
import Model.TypeModel.RoomModel;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Room extends Model{
    static String endpoint = "rooms";


    public Room(JSONObject jsonObject) {
    }

    public static void list(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.list(endpoint, data, header, response, Room.class);
    }

    public static void show(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.show(endpoint, data, header, response, Room.class);
    }

    public static void create(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.create(endpoint, data, header, response, Room.class);
    }

    public static void delete(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.delete(endpoint, data, header, response, Room.class);
    }

    public static void update(HashMap<String, Object> data, HashMap<String, Object> header, Response response) throws IOException {
        Model.update(endpoint, data, header, response, Room.class);
    }
}
