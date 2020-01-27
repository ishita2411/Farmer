package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Name,District,Mandal,City,State;
    private Button submit;
    String s1,s2,s3,s4,s5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etMandal);
        District=(EditText)findViewById(R.id.etMandal);
        Mandal=(EditText)findViewById(R.id.etMandal);
        City=(EditText)findViewById(R.id.etCity);
        State=(EditText)findViewById(R.id.etState);
        submit=(Button) findViewById(R.id.btnSubmit);
        s1=Name.getText().toString().trim();
        s2=District.getText().toString().trim();
        s3=Mandal.getText().toString().trim();
        s4=City.getText().toString().trim();
        s5=State.getText().toString().trim();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,FarmerLogin.class);
                startActivity(i1);
            }
        });
    }
}
