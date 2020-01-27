package com.example.farmer;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.util.ArrayList;

public class driver extends AppCompatActivity {

    private EditText name1,license1,vehicle_num1,area1,mandal1,state1,district1;
    private Button go;
    String name,license,vehicle_num,area,mandal,state,district;
    String vehicle_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        name1=(EditText)findViewById(R.id.driver_name_field);
        license1=(EditText)findViewById(R.id.license_id_field);
        vehicle_num1=(EditText)findViewById(R.id.vehicle_number_field);
        area1=(EditText)findViewById(R.id.editText3);
        mandal1=(EditText)findViewById(R.id.editText4);
        district1=(EditText)findViewById(R.id.editText5);
        state1=(EditText)findViewById(R.id.editText6);
        go=(Button)findViewById(R.id.button);

        name=name1.getText().toString().trim();
        license=license1.getText().toString().trim();
        vehicle_num=vehicle_num1.getText().toString().trim();
        area=area1.getText().toString().trim();
        mandal=mandal1.getText().toString().trim();
        district=district1.getText().toString().trim();
        state=state1.getText().toString().trim();
        go.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i1 = new Intent(driver.this,after_driver.class);
                startActivity(i1);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Truck");
        arrayList.add("DCM");
        arrayList.add("TATA ACE");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vehicle_type = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),"selected: "+ vehicle_type, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}


