package API;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestData {
    private Boolean hasFile = false;
    private HashMap<String, Object> data = new HashMap<>();

    public void set(String key, String value) {
        if (value != null)
        data.put(key, value);
    }

    public void set(String key, File value) {
        hasFile = true;
        data.put(key, value);
    }

    public void set(String key,Object value){
        data.put(key,value);
    }

    public HashMap<String, Object> get() {
        return data;
    }


    public String body(String url) {
        String new_url;
        if (url.contains("?")) {
            new_url = url + '&';
        } else {
            new_url = url + '?';
        }
        ArrayList<String> qp = new ArrayList<>();
        for (String key : data.keySet()) {
            qp.add(key + "=" + data.get(key));
        }

        new_url += String.join("&", qp);
        return new_url;
    }

    public RequestBody body() throws IOException {
        if(hasFile){
            return multipartBody();
        }
        return formBody();
    }

    public RequestBody formBody() {
        RequestBody requestBody;
        FormBody.Builder formBody = new FormBody.Builder();
        for (String key : data.keySet()) {
            formBody.add(key, (String) data.get(key));
        }
        requestBody = formBody.build();
        return requestBody;
    }

    public RequestBody multipartBody() throws IOException {
        RequestBody requestBody;
        MultipartBody.Builder multiPart = new MultipartBody.Builder();
        for (String key : data.keySet()) {

            if (data.get(key).getClass().getName().equals("java.io.File")){
                File file = (File) data.get(key);
                Path path = file.toPath();
                String mimeType = Files.probeContentType(path);
                multiPart.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse(mimeType), file));
            }else {
                multiPart.addFormDataPart(key, (String) data.get(key));
            }
        }
        requestBody = multiPart.build();
        return requestBody;
    }

}
