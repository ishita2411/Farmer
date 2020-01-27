package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class FirstPage extends AppCompatActivity {
    FirebaseAuth auth;
    String verification_code;
    private EditText e1,e2;
    private Button submit,otp;
    String s1,s2;
    RadioButton farmer,driver;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        submit=(Button)findViewById(R.id.button2);
        otp=(Button)findViewById(R.id.button);
        s1=e1.getText().toString().trim();
        s2=e2.getText().toString().trim();
        farmer=(RadioButton)findViewById(R.id.radioButton);
        driver=(RadioButton)findViewById(R.id.radioButton2);
        e1 = (EditText) findViewById(R.id.editText);
        auth = FirebaseAuth.getInstance();
        mcallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verification_code = s;
                Toast.makeText(getApplicationContext(), "code sent to the number", Toast.LENGTH_SHORT).show();
            }

        };
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(farmer.isChecked()){
                    Intent i1= new Intent(FirstPage.this,MainActivity.class);
                    startActivity(i1);
                }

                if(driver.isChecked()){
                    Intent i1= new Intent(FirstPage.this,driver.class);
                    startActivity(i1);
                }

            }
        });
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= e1.getText().toString();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS,FirstPage.this,mcallBack);
            }
        });

    }
}

