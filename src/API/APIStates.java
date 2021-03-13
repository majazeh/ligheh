package API;

public class APIStates extends APIStateInitializer {


    @Override
    boolean onPreRequest() {
        return false;
    }

    @Override
    boolean onResponsed(Object parameter) {
        return true;
    }


}
