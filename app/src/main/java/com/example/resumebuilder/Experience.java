package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Experience extends AppCompatActivity {
    ArrayList<ExperienceModel> arrExperience=new ArrayList<>();
    FloatingActionButton btn;
    RecyclerAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerexperience);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        RecyclerView recyclerView=findViewById(R.id.re);
        btn=findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(Experience.this);
                dialog.setContentView(R.layout.addexperience);
                EditText edtcname=dialog.findViewById(R.id.edtcname);
                EditText edtjtitle=dialog.findViewById(R.id.edtJtitle);
                EditText edtdur=dialog.findViewById(R.id.edtDur);
                EditText edtdetails=dialog.findViewById(R.id.edtdetail);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cname=edtcname.getText().toString();
                        String jtitle=edtjtitle.getText().toString();
                        String details=edtdur.getText().toString();
                        String dur=edtdur.getText().toString();
                        arrExperience.add(new ExperienceModel(cname,jtitle,dur,details));
                        adapter.notifyItemInserted(arrExperience.size()-1);
                        recyclerView.scrollToPosition(arrExperience.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        arrExperience.add(new ExperienceModel("","","",""));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecyclerAdapter3(this,arrExperience);
        recyclerView.setAdapter(adapter);

    }
}
