package com.example.resumebuilder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Templates extends AppCompatActivity {
    ImageButton temp1, temp2, temp3, temp4, temp5, temp6;
    Button down2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

       // down2 = findViewById(R.id.button2);
        temp1 = findViewById(R.id.Template1);
        temp2 = findViewById(R.id.Template2);
        temp3 = findViewById(R.id.Template3);

//        down2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Template3 t1=new Template3();
//                t1.xmlToPdf();
//            }
//        });

        temp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Templates.this, Template1.class);
                startActivity(i1);
            }
        });

        temp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Templates.this, Template2.class);
                startActivity(i2);
            }
        });

        temp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Templates.this, Template3.class);
                startActivity(i3);
            }
        });
    }


}
