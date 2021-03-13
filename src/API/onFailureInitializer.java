package API;

import java.util.HashMap;

public class onFailureInitializer extends onFailureException {

    public onFailureInitializer(Object object) {
        super(object);
    }

    @Override
    void onValidation(HashMap<String, Object> object) {
        log("onValidation: " + object);
    }

    @Override
    void onClient(Object object) {
        log("onClient: " + object);
    }

    @Override
    void onServerFail(Object object) {
        log("onServerFail: " + object);
    }

    @Override
    void onAuth(Object object) {
        log("onAuth: " + object);
    }

    public void log(Object object) {
        System.out.println(object);
    }

}
