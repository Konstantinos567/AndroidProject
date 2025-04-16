package gr.uom.carpicker;

import java.util.ArrayList;
import java.util.List;

public class CarBrandsList {
    ArrayList<Brand> bList = new ArrayList<Brand>();

    public CarBrandsList() {
        bList.add(new Brand("Toyota"));
        bList.add(new Brand("VW"));
        bList.add(new Brand("Nissan"));

        addModel("Toyota", "Auris");
        addModel("Toyota", "Yaris");
        addModel("Toyota", "Rav14");
        addModel("VW", "Golf");
        addModel("VW", "Polo");

    }

    public void addModel(String brand, String model) {
        for (int i=0; i<bList.size(); i++) {
            if (bList.get(i).isBrand(brand)) {
                bList.get(i).addModel(model);
            }
        }
    }

    public List<String> getCars(String brand) {
        for (int i=0; i<bList.size(); i++) {
            if (bList.get(i).isBrand(brand)) {
                return bList.get(i).getModels();
            }
        }
        return null;
    }

}
