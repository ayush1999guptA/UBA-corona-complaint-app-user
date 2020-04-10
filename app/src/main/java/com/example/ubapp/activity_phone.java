package com.example.ubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class activity_phone extends AppCompatActivity {
    private EditText phoneNumber;
    private Button btn;
    private String phno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        phoneNumber= findViewById(R.id.editTextPhone);

        btn=findViewById(R.id.buttonContinue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phno = phoneNumber.getText().toString().trim();
                if(phno.isEmpty() || phno.length()<10){
                    phoneNumber.setError("Valid Number is required");
                    phoneNumber.requestFocus();
                    return;
                }
                String number="+91"+phoneNumber;
                Intent intent=new Intent(activity_phone.this,activity_otp.class);
                intent.putExtra("phonenumber",number);
                startActivity(intent);
            }
        });
    }


}
