package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Template1 extends AppCompatActivity {
    TextView name,phone,address,email,linkedin;
    ImageView picture;
    TextView desc;
    DatabaseReference personalDetails,objective;

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
        picture=(ImageView)findViewById(R.id.photo);


        desc=(TextView)findViewById(R.id.profiled);

        personalDetails= FirebaseDatabase.getInstance().getReference().child("Personal Details");
        Query query=personalDetails.limitToLast(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();

                Model model = latestSnapshot.getValue(Model.class);
                String imageUrl = model.getImageUri();
                if (!isDestroyed() && imageUrl != null) {
                    Glide.with(Template1.this).load(Uri.parse(imageUrl)).into(picture);
                }

                String fname=latestSnapshot.child("name").getValue(String.class);
                String fphone=latestSnapshot.child("phone").getValue(String.class);
                String fadd=latestSnapshot.child("address").getValue(String.class);
                String fmail=latestSnapshot.child("email").getValue(String.class);
                String flinkedin=latestSnapshot.child("LinkedIn").getValue(String.class);

                name.setText(fname);
                phone.setText(fphone);
                address.setText(fadd);
                email.setText(fmail);
                linkedin.setText(flinkedin);
          
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        objective=FirebaseDatabase.getInstance().getReference().child("Objective");
        Query query1=objective.limitToLast(1);
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                String fdesc=latestSnapshot.child("objective").getValue(String.class);
                desc.setText(fdesc);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}