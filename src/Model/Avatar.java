package Model;

import Model.TypeModel.AvatarModel;
import org.json.JSONArray;
import org.json.JSONObject;

public class Avatar extends Model {
    public AvatarModel model;
    public Avatar(JSONArray jsonArray) {
        super.data = new AvatarModel(jsonArray);
        model = (AvatarModel) super.data;
    }
}
