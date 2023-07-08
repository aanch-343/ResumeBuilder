package com.example.resumebuilder;


import androidx.annotation.NonNull;

import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Template2 extends AppCompatActivity {

    TextView name,phone,address,email,companyref,jobref,emailref,nameref,linkdin,desc;
   Button download;
    DatabaseReference personalDetails,objective,skills,Experience,Education,Reference;
    ListView list1,list2,list3;
    ArrayList<Edutemp> edutempArrayList;
    ArrayList<Exptemp> exptempArrayList;
    ArrayList<Skilltemp> skilltempArrayList;
FirebaseDatabase firebaseDatabaseducation,firebaseDatabaseexp,firebaseDatabaseskill;
    private PdfGenerator.XmlToPDFLifecycleObserver xmlToPDFLifecycleObserver;
   ExpTempAdapter adapter2;
    EduTempAdapter adapter1;
    SkillTempAdapter adapter3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        download = (Button) findViewById(R.id.button2);
        name = (TextView) findViewById(R.id.name);
        phone = (TextView) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        email = (TextView) findViewById(R.id.email);
        linkdin = (TextView) findViewById(R.id.linkedIn);
        desc = (TextView) findViewById(R.id.objective);
        nameref = (TextView) findViewById(R.id.referenceName);
        companyref = (TextView) findViewById(R.id.companyref);
        jobref = (TextView) findViewById(R.id.jobref);
        emailref = (TextView) findViewById(R.id.emailRef);
        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        list3 = findViewById(R.id.list3);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xmlToPdf();
            }
        });


        personalDetails = FirebaseDatabase.getInstance().getReference().child("Personal Details");
        Query query = personalDetails.limitToLast(1);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();

                String fname = latestSnapshot.child("name").getValue(String.class);
                String fphone = latestSnapshot.child("phone").getValue(String.class);
                String fadd = latestSnapshot.child("address").getValue(String.class);
                String fmail = latestSnapshot.child("email").getValue(String.class);
                String flinkedin = latestSnapshot.child("LinkedIn").getValue(String.class);

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
        objective = FirebaseDatabase.getInstance().getReference().child("Objective");
        Query query1 = objective.limitToLast(1);
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();
                    String fdesc = latestSnapshot.child("objective").getValue(String.class);
                    desc.setText(fdesc);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Reference = FirebaseDatabase.getInstance().getReference().child("Reference");
        Query query2 = Reference.limitToLast(1);
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot latestSnapshot = snapshot.getChildren().iterator().next();


                String namerefer = latestSnapshot.child("Reference").getValue(String.class);
                String jobrefer = latestSnapshot.child("Job").getValue(String.class);
                String companyrefer = latestSnapshot.child("Company").getValue(String.class);
                String emailrefer = latestSnapshot.child("Email").getValue(String.class);
                nameref.setText(namerefer);
                jobref.setText(jobrefer);
                companyref.setText(companyrefer);
                emailref.setText(emailrefer);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


        edutempArrayList = new ArrayList<Edutemp>();
        adapter1 = new EduTempAdapter(Template2.this, R.layout.listeducation, edutempArrayList);

        firebaseDatabaseducation = FirebaseDatabase.getInstance();
        Education = firebaseDatabaseducation.getReference();
        Education.child("Education").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                edutempArrayList.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String course = ds.child("course").getValue(String.class);
                    String grade = ds.child("grade").getValue(String.class);
                    String school = ds.child("school").getValue(String.class);
                    String year = ds.child("year").getValue(String.class);
                    edutempArrayList.add(new Edutemp("" + course, "" + grade, "" + school, "" + year));
                    adapter1.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        list1.setAdapter(adapter1);
        exptempArrayList = new ArrayList<Exptemp>();
        adapter2 = new ExpTempAdapter(Template2.this, R.layout.listexperience, exptempArrayList);

        firebaseDatabaseexp = FirebaseDatabase.getInstance();
        Experience = firebaseDatabaseexp.getReference();
        Experience.child("Experience").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                exptempArrayList.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String company = ds.child("Company").getValue(String.class);
                    String job = ds.child("Job").getValue(String.class);
                    String dur = ds.child("Dur").getValue(String.class);
                    String details = ds.child("Details").getValue(String.class);
                    exptempArrayList.add(new Exptemp("" + company, "" + job, "" + dur, "" + details));
                    adapter2.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        list2.setAdapter(adapter2);
        skilltempArrayList = new ArrayList<Skilltemp>();
        adapter3 = new SkillTempAdapter(Template2.this, R.layout.listskill, skilltempArrayList);

        firebaseDatabaseskill = FirebaseDatabase.getInstance();
        skills = firebaseDatabaseducation.getReference();
        skills.child("Skills").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                skilltempArrayList.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String skill = ds.child("Skills").getValue(String.class);
                    skilltempArrayList.add(new Skilltemp("" + skill));
                    adapter3.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        list3.setAdapter(adapter3);
    }
        public void xmlToPdf() {

            View v = findViewById(R.id.mainView);
            PdfGenerator.getBuilder()
                    .setContext(Template2.this)
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
                            Toast.makeText(Template2.this, "" + failureResponse.getErrorMessage(), Toast.LENGTH_LONG).show();

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
                            Toast.makeText(Template2.this, "done", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(SuccessResponse response) {
                            super.onSuccess(response);
                        }
                    });


    }}
