package API;

import org.json.JSONObject;

import java.util.HashMap;

public class onFailureUserInterface extends onFailureException {
    protected Object exception;

    public onFailureUserInterface(Object object) {
        super(object);
        this.exception = object;
    }

    @Override
    void onValidation(HashMap<String, Object> object) {

    }

    @Override
    void onClient(Object object) {

    }

    @Override
    void onServerFail(Object object) {
    }

    @Override
    void onAuth(Object object) {

    }


}
