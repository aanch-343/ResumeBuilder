package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import com.bumptech.glide.Glide;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Template3 extends AppCompatActivity {
    TextView name,phone,address,email,job,company,duration,detail,school,course,year,grade,linkdin,nameref,jobref,companyref,emailref,skill1,skill2;
    ImageView picture;
    TextView desc;
   Button download;
    DatabaseReference personalDetails,objective,skills,Experience,Education,Reference;
    private PdfGenerator.XmlToPDFLifecycleObserver xmlToPDFLifecycleObserver;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
       download=(Button)findViewById(R.id.button2);
        name=(TextView)findViewById(R.id.name);
        phone=(TextView)findViewById(R.id.phone);
        address=(TextView)findViewById(R.id.address);
        email=(TextView)findViewById(R.id.email);
        picture=(ImageView)findViewById(R.id.photo);
        job=(TextView)findViewById(R.id.job);
        duration=(TextView)findViewById(R.id.dur);
        detail=(TextView)findViewById(R.id.detail);
        company=(TextView)findViewById(R.id.company);
        school=(TextView)findViewById(R.id.school);
        course=(TextView)findViewById(R.id.course);
        year=(TextView)findViewById(R.id.year);
        grade=(TextView)findViewById(R.id.grade);
        nameref=(TextView)findViewById(R.id.referenceName);
        companyref=(TextView)findViewById(R.id.companyref);
        jobref=(TextView)findViewById(R.id.jobref);
        emailref=(TextView)findViewById(R.id.emailRef);
        desc=(TextView)findViewById(R.id.objective);
        linkdin=(TextView)findViewById(R.id.linkedIn);
        skill1=(TextView)findViewById(R.id.skill1);
        skill2=(TextView)findViewById(R.id.skill2);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xmlToPdf();
            }
        });

        personalDetails= FirebaseDatabase.getInstance().getReference().child("Personal Details");
        Query query=personalDetails.limitToLast(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();

                String fname=latestSnapshot.child("name").getValue(String.class);
                String fphone=latestSnapshot.child("phone").getValue(String.class);
                String fadd=latestSnapshot.child("address").getValue(String.class);
                String fmail=latestSnapshot.child("email").getValue(String.class);
                String flinkedin=latestSnapshot.child("LinkedIn").getValue(String.class);

                name.setText(fname);
                phone.setText(fphone);
                address.setText(fadd);
                email.setText(fmail);
               linkdin.setText(flinkedin);


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
        Query query2=skills.limitToLast(2);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {

                    DataSnapshot dataSnapshot = snapshot.getChildren().iterator().next();
                    String fdesc=dataSnapshot.child("Skills").getValue(String.class);
                    skill1.setText(fdesc);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Education= FirebaseDatabase.getInstance().getReference().child("Education");
        Query query3=Education.limitToLast(2);
        query3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();


                String school1=latestSnapshot.child("school").getValue(String.class);
                String year1=latestSnapshot.child("course").getValue(String.class);
                String course1=latestSnapshot.child("year").getValue(String.class);
                String grade1=latestSnapshot.child("grade").getValue(String.class);
                school.setText(school1);
              year.setText(year1);
                course.setText(course1);
                grade.setText(grade1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        Experience= FirebaseDatabase.getInstance().getReference().child("Experience");
        Query query4=Experience.limitToLast(2);
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
        Reference= FirebaseDatabase.getInstance().getReference().child("Reference");
        Query query5=Reference.limitToLast(1);
        query5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();


                String namerefer=latestSnapshot.child("Reference").getValue(String.class);
                String jobrefer=latestSnapshot.child("Job").getValue(String.class);
                String companyrefer=latestSnapshot.child("Company").getValue(String.class);
                String emailrefer=latestSnapshot.child("Email").getValue(String.class);
                nameref.setText(namerefer);
                jobref.setText(jobrefer);
                companyref.setText(companyrefer);
                emailref.setText(emailrefer);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
    public void xmlToPdf() {

        View v = findViewById(R.id.mainView);
        PdfGenerator.getBuilder()
                .setContext(Template3.this)
                .fromViewSource()
                .fromView(v)
                .setFileName("Resume")
                .setFolderNameOrPath("Resume-builder")
                .savePDFSharedStorage(xmlToPDFLifecycleObserver)
                .actionAfterPDFGeneration(PdfGenerator.ActionAfterPDFGeneration.OPEN)
                .build(new PdfGeneratorListener() {
                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                        Toast.makeText(Template3.this, "" + failureResponse.getErrorMessage(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void showLog(String log) {
                        super.showLog(log);
                    }

                    @Override
                    public void onStartPDFGeneration() {
                                /*When PDF generation begins to start*/
                    }

                    @Override
                    public void onFinishPDFGeneration() {
                        Toast.makeText(Template3.this, "done", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        super.onSuccess(response);
                    }
                });
    }
}