package API;


import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;

public class Exceptioner {
    public static Class External;

    public static void make(Object object) {
        if (External != null) {
            try {
                External.getDeclaredConstructor(Object.class).newInstance(object);
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            new onFailureInitializer(object);
        }
    }
}
