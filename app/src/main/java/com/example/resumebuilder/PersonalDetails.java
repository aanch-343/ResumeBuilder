package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PersonalDetails extends AppCompatActivity {
    EditText name,address,email,phone,dob,linkedin;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        getSupportActionBar().setTitle("Personal details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.address);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        dob=(EditText)findViewById(R.id.dob);
        linkedin=(EditText)findViewById(R.id.linkedIn);
        done=(Button)findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> m=new HashMap<String, Object>();
                m.put("name",name.getText().toString());
                m.put("address",address.getText().toString());
                m.put("email",email.getText().toString());
                m.put("phone",phone.getText().toString());
                m.put("dob",dob.getText().toString());
                m.put("LinkedIn",linkedin.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Personal Details").push().setValue(m);
            }

        });

    }
}