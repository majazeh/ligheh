package API;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

public class APICustomization {
    public Class External;
    public APIStates apiStates;

    public APICustomization() {
//        try {
//            this.apiStates = new APIStates();
//            External.newInstance();
//        } catch (IllegalAccessException | InstantiationException e) {
//            e.printStackTrace();
//        }
    }

    public void make(Object object, @Nullable Object parameter) {
//        if (External != null) {
//            try {
//                External.getDeclaredConstructor(Object.class).newInstance(object);
//            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } else {
//            apiStates = new APIStates();
//        }
    }
}
