package API;

public abstract class APIStateInitializer {

    abstract boolean onPreRequest();

    abstract boolean onResponsed(Object parameter);


}
