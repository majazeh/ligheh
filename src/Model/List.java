package Model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class List {
    private ArrayList<Model> models;
    private final ArrayList<String> index;
    private JSONObject data;
    private int page = 1;

    public List() {
        index = new ArrayList<>();
        models = new ArrayList<>();
    }

    public Model get(String id) {
        if (index.contains(id))
        return models.get(index.indexOf(id));
        else
            return null;
    }

    public Model get(int index) {
        if (index <= size()) {
            return models.get(index);
        }
        return null;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public Object getData() {
        if (data == null)
            return null;
        else
            return data;
    }

    public void add(Model model) {
        models.add(model);
    }

    public JSONObject meta() {
        if (getData() != null)
            return ((JSONObject) getData()).getJSONObject("meta");
        else
            return null;
    }


    public void setPage(int page) {
        this.page = page;
    }

    public int nextPage() {
        return getPage() + 1;
    }

    public int prevPage() {
        return getPage() - 1;
    }

    public int getPage() {
        if (meta() != null && !meta().isNull("current_page"))
            return meta().getInt("current_page");
        else
            return page;
    }

    public JSONObject filters() {
        if (meta() != null)
            return meta().getJSONObject("filters");
        else
            return null;
    }

    public HashMap<String, Object> filterAllows() {
        if (filters() != null) {
            HashMap hashMap = new HashMap();
            JSONObject allowed = filters().getJSONObject("allowed");
            Iterator<String> keys = allowed.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                hashMap.put(key, allowed.get(key));
            }
            return hashMap;
        } else
            return null;
    }

    public ArrayList<String> filtersAllowsKeys() {
        if (filterAllows() != null) {
            return new ArrayList(filterAllows().keySet());
        } else
            return null;
    }

    public Object filterAllowed(String key) {
        if (filterAllows() != null)
            if (filtersAllowsKeys().contains(key))
                return filterAllows().get(key);
            else
                return null;
        else
            return null;
    }

    public HashMap filterCurrents() {
        if (filters() != null) {
            if (!filters().isNull("current")) {
                if ("org.json.JSONObject".equals(filters().get("current").getClass().getName())) {
                    JSONObject current = filters().getJSONObject("current");
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = current.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        hashMap.put(key, current.get(key));
                    }
                    return hashMap;
                }
            }
        }
        return null;
    }

    public boolean filterCurrent(String key) {
        if (filters() != null) {
            if (!filters().isNull("current")) {
                if ("org.json.JSONObject".equals(filters().get("current").getClass().getName())) {
                    JSONObject current = filters().getJSONObject("current");
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = current.keys();
                    while (keys.hasNext()) {
                        String key1 = keys.next();
                        if (key.equals(key1))
                            return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public ArrayList filterSingle(String key) {
        if (filtersAllowsKeys() != null) {
            if (filtersAllowsKeys().contains(key)) {
                ArrayList arrayList = new ArrayList();

            }
        }
        return null;
    }


    public ArrayList<Model> list() {
        return models;
    }

    public int size() {
        return models.size();
    }

    @Override
    public String toString() {
        String outPut = "";
        for (Model model : models) {
            outPut += model + "\n";
        }
        return "models=" + outPut +
                '}';
    }
}
