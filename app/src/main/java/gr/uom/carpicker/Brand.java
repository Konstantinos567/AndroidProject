package gr.uom.carpicker;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private String name;
    private ArrayList<String> mList = new ArrayList<String>();

    public Brand(String n) {
        name = n;
    }

    public boolean isBrand(String brand) {
        return name.equals(brand);
    }

    public void addModel(String model) {
        mList.add(model);
    }

    public List<String> getModels() {
        return mList;
    }
}
