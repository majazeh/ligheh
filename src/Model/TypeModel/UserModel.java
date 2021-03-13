package Model.TypeModel;

import Model.Avatar;
import Model.Center;
import Model.List;
import org.json.JSONObject;

public class UserModel  extends TypeModel{
     private String name;
     private String email;
     private String mobile;
     private String gender;
     private String status;
     private String position;
     private String type;
     private Object groups;
     private String username;
     private String public_key;
     private String birthday;
     private int created_at;
     private int updated_at;
     private Avatar avatar;
     private List centerList;

    public UserModel(JSONObject jsonObject) {
        setId(jsonObject.getString("id"));
        if (!jsonObject.isNull("name"))
            setName(jsonObject.getString("name"));
        if (!jsonObject.isNull("email"))
            setEmail(jsonObject.getString("email"));
        if (!jsonObject.isNull("mobile"))
            setMobile(jsonObject.getString("mobile"));
        if (!jsonObject.isNull("gender"))
            setGender(jsonObject.getString("gender"));
        if (!jsonObject.isNull("status"))
            setStatus(jsonObject.getString("status"));
        if (!jsonObject.isNull("position"))
            setPosition(jsonObject.getString("position"));
        if (!jsonObject.isNull("public_key"))
            setPublic_key(jsonObject.getString("public_key"));
        if (!jsonObject.isNull("type"))
            setType(jsonObject.getString("type"));
        if (!jsonObject.isNull("groups"))
            setGroups(jsonObject.getString("groups"));
        if (!jsonObject.isNull("username"))
           setUsername(jsonObject.getString("username"));
        if (!jsonObject.isNull("public_key"))
           setPublic_key(jsonObject.getString("public_key"));
        if (!jsonObject.isNull("birthday"))
            setBirthday(jsonObject.getString("birthday"));
        if (!jsonObject.isNull("created_at"))
            setCreated_at(jsonObject.getInt("created_at"));
        if (!jsonObject.isNull("updated_at"))
            setUpdated_at(jsonObject.getInt("updated_at"));
        if (!jsonObject.isNull("avatar"))
            setAvatar(new Avatar(jsonObject.getJSONArray("avatar")));
        if (!jsonObject.isNull("centers")){
            List centers = new List();
            for (int i = 0; i < jsonObject.getJSONArray("centers").length(); i++) {
                centers.add(new Center(jsonObject.getJSONArray("centers").getJSONObject(i)));
            }
            setCenterList(centers);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getGroups() {
        return groups;
    }

    public void setGroups(Object groups) {
        this.groups = groups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public List getCenterList() {
        return centerList;
    }

    public void setCenterList(List centerList) {
        this.centerList = centerList;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", position='" + position + '\'' +
                ", type='" + type + '\'' +
                ", groups=" + groups +
                ", username='" + username + '\'' +
                ", public_key='" + public_key + '\'' +
                ", birthday='" + birthday + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", avatar=" + avatar +
                ", centerList=" + centerList;
    }
}
