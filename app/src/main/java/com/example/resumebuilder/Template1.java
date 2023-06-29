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
    TextView name,phone,address,email,job,company,duration,detail,school,course,year,grade;
    ImageView picture;
    TextView desc;
    DatabaseReference personalDetails,objective,skills,Experience,Education,Reference;

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
        picture=(ImageView)findViewById(R.id.photo);
        job=(TextView)findViewById(R.id.job);
        duration=(TextView)findViewById(R.id.dur);
        detail=(TextView)findViewById(R.id.detail);
        company=(TextView)findViewById(R.id.companyName);
        school=(TextView)findViewById(R.id.school);
        course=(TextView)findViewById(R.id.course);
        year=(TextView)findViewById(R.id.year);
        grade=(TextView)findViewById(R.id.grade);

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
                if (snapshot.hasChildren()) {
                    DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                    String fdesc=latestSnapshot.child("objective").getValue(String.class);
                    desc.setText(fdesc);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        skills=FirebaseDatabase.getInstance().getReference().child("Skills");
        Query query2=skills.limitToLast(1);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                    String fdesc=latestSnapshot.child("Skills").getValue(String.class);
                    desc.setText(fdesc);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        Education= FirebaseDatabase.getInstance().getReference().child("Education");
//        Query query3=Education.limitToLast(1);
//        query3.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
//
//
//                String school1=latestSnapshot.child("School").getValue(String.class);
//                String year1=latestSnapshot.child("Course").getValue(String.class);
//                String course1=latestSnapshot.child("Year").getValue(String.class);
//                String grade1=latestSnapshot.child("Grade").getValue(String.class);
//                school.setText(school1);
//              year.setText(year1);
//                course.setText(course1);
//                grade.setText(grade1);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//        });
        Experience= FirebaseDatabase.getInstance().getReference().child("Experience");
        Query query4=Experience.limitToLast(1);
        query4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();


                String company1=latestSnapshot.child("Company").getValue(String.class);
                String detail1=latestSnapshot.child("Details").getValue(String.class);
                String dur1=latestSnapshot.child("Dur").getValue(String.class);
                String job1=latestSnapshot.child("Job").getValue(String.class);
                company.setText(company1);
               detail.setText(detail1);
               duration.setText(dur1);
               job.setText(job1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
}