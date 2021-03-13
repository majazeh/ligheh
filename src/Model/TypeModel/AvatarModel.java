package Model.TypeModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class AvatarModel extends TypeModel {
    private JSONObject large;
    private JSONObject medium;
    private JSONObject original;
    private JSONObject small;

    public AvatarModel(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            switch (jsonArray.getJSONObject(i).getString("mode")) {
                case "small" : setSmall(jsonArray.getJSONObject(i));break;
                case "original" : setOriginal(jsonArray.getJSONObject(i));break;
                case "medium" : setMedium(jsonArray.getJSONObject(i));break;
                case "large" : setLarge(jsonArray.getJSONObject(i));break;
            }

        }
    }

    public JSONObject getLarge() {
        return large;
    }

    public void setLarge(JSONObject large) {
        this.large = large;
    }

    public JSONObject getMedium() {
        return medium;
    }

    public void setMedium(JSONObject medium) {
        this.medium = medium;
    }

    public JSONObject getOriginal() {
        return original;
    }

    public void setOriginal(JSONObject original) {
        this.original = original;
    }

    public JSONObject getSmall() {
        return small;
    }

    public void setSmall(JSONObject small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "large=" + large +
                ", medium=" + medium +
                ", original=" + original +
                ", small=" + small;
    }
}
