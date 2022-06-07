package API;


import java.io.IOException;

public  interface Response<T> {
    void onOK(T t);

}
