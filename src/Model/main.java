package Model;

import API.Response;
import Model.TypeModel.TypeModel;

import java.io.IOException;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        TypeModel typeModel = new TypeModel();
        Model<TypeModel> model = new Model(typeModel);
        try {
            model.post("https://reqbin.com/sample/post/json", new HashMap<>(), new HashMap<>(), new Response<TypeModel>() {
                @Override
                public void onOK(TypeModel typeModel) {
                    System.out.println(typeModel.toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
