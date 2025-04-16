package gr.uom.carpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;

public class PickCarActivity extends AppCompatActivity {
    private CarBrandsList cbList;
    ConstraintLayout layout;
    RadioGroup rg;

    private void createRadioButtons(RadioGroup rg, List<String> brandsList) {
        for(int i=0; i<brandsList.size(); i++){
            RadioButton rb = new RadioButton(this);
            rb.setText(" " + brandsList.get(i));
            rb.setId(i + 100);
            rg.addView(rb);
        }
    }

    public void onClickPickCar(View view) {
        Spinner dropDown  = (Spinner) findViewById(R.id.cars);
        String brand = String.valueOf(dropDown.getSelectedItem());

        List<String> brandsList = cbList.getCars(brand);
        rg.removeAllViews();

        if(brandsList.size() == 0){
            Toast.makeText(getApplicationContext(), getString(R.string.toast_no_cars, brand), Toast.LENGTH_SHORT).show();
        } else{
            rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
            createRadioButtons(rg, brandsList);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rb=(RadioButton)findViewById(checkedId);
                    Toast.makeText(getApplicationContext(), brand+" "+rb.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbList = new CarBrandsList();

        layout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        rg = (RadioGroup) findViewById(R.id.car_radio);

    }
}
