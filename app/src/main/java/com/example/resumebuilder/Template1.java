package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Template1 extends AppCompatActivity {
    TextView name,phone,address,email,linkedin,dob;
    TextView desc;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        name=(TextView)findViewById(R.id.Name);
        phone=(TextView)findViewById(R.id.phone);
        address=(TextView)findViewById(R.id.address);
        email=(TextView)findViewById(R.id.mail);
        linkedin=(TextView)findViewById(R.id.link);
        //dob=(TextView)findViewById(R.id.);

        desc=(TextView)findViewById(R.id.profiled);

        ref= FirebaseDatabase.getInstance().getReference().child("Personal Details");
        Query query=ref.limitToLast(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                String fname=latestSnapshot.child("name").getValue(String.class);
                String fphone=latestSnapshot.child("phone").getValue(String.class);
                String fadd=latestSnapshot.child("address").getValue(String.class);
                String fmail=latestSnapshot.child("email").getValue(String.class);
                String flinkedin=latestSnapshot.child("LinkedIn").getValue(String.class);
                //String fdob=latestSnapshot.child("dob").getValue(String.class);

                name.setText(fname);
                phone.setText(fphone);
                address.setText(fadd);
                email.setText(fmail);
                linkedin.setText(flinkedin);
                //dob.setText(fdob);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}