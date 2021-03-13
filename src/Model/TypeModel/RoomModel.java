package Model.TypeModel;

import Model.Center;
import org.json.JSONObject;

public class RoomModel extends TypeModel {
    private Object manager;
    private Object creator;
    private Object acceptation;
    private String status;
    private String type;
    private Center center;
    private int created_at;
    private int updated_at;

    public RoomModel(JSONObject jsonObject) {
    }
}
