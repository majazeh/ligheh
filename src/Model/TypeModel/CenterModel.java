package Model.TypeModel;

import Model.User;
import org.json.JSONObject;

public class CenterModel extends TypeModel {
    private String name;
    private String status;
    private String type;
    private User manager;
    private JSONObject acceptation;
    private JSONObject detail;
    private int created_at;
    private int updated_at;

    public CenterModel(JSONObject jsonObject) {
        setId(jsonObject.getString("id"));
        if (!jsonObject.isNull("manager"))
            setManager(new User(jsonObject.getJSONObject("manager")));
        if (!jsonObject.isNull("acceptation"))
            setAcceptation(jsonObject.getJSONObject("acceptation"));
        if (!jsonObject.isNull("status"))
            setStatus(jsonObject.getString("status"));
        if (!jsonObject.isNull("type"))
            setType(jsonObject.getString("type"));
        if (!jsonObject.isNull("detail"))
            setDetail(jsonObject.getJSONObject("detail"));
        if (!jsonObject.isNull("created_at"))
            setCreated_at(jsonObject.getInt("created_at"));
        if (!jsonObject.isNull("updated_at"))
            setUpdated_at(jsonObject.getInt("updated_at"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public JSONObject getAcceptation() {
        return acceptation;
    }

    public void setAcceptation(JSONObject acceptation) {
        this.acceptation = acceptation;
    }

    public JSONObject getDetail() {
        return detail;
    }

    public void setDetail(JSONObject detail) {
        this.detail = detail;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", manager=" + manager +
                ", acceptation=" + acceptation +
                ", detail=" + detail +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at;
    }
}
