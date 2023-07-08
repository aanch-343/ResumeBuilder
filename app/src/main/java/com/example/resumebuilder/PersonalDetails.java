
package com.example.resumebuilder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class PersonalDetails extends AppCompatActivity {
    EditText name,address,email,phone,linkedin;
    ImageView img;
    Button done,add;
    private Uri  imageUri;
    String pic;

    FirebaseStorage storage;
    //FirebaseDatabase db;
    private DatabaseReference db=FirebaseDatabase.getInstance().getReference("Personal Details");
    private StorageReference reference=FirebaseStorage.getInstance().getReference();
    private final int GALLERY_REQ_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        img=(ImageView)findViewById(R.id.photo);
        add=(Button)findViewById(R.id.add);
        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.address);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        linkedin=(EditText)findViewById(R.id.linkedIn);
        done=(Button)findViewById(R.id.Done);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGallery=new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);

            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> m=new HashMap<String, Object>();
                m.put("name",name.getText().toString());
                m.put("address",address.getText().toString());
                m.put("email",email.getText().toString());
                m.put("phone",phone.getText().toString());
                m.put("LinkedIn",linkedin.getText().toString());

                //uploading image
                if(imageUri!=null){
                    uploadToFirebase(imageUri,m);

                }
                else{
                    Toast.makeText(PersonalDetails.this,"Please select image",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void uploadToFirebase(Uri uri, HashMap<String, Object> m) {

        StorageReference fileRef=reference.child(System.currentTimeMillis()+"."+getFileExtension(uri));
        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        m.put("imageUri", uri.toString());
                        db.push().setValue(m);
                        Toast.makeText(PersonalDetails.this,"Uploaded Successfully",Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(PersonalDetails.this,Menuu.class) ;
                        startActivity(i1);

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PersonalDetails.this,"Uploading Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private String getFileExtension(Uri mUri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            if(requestCode==GALLERY_REQ_CODE){
                //for gallery
                imageUri=data.getData();
                img.setImageURI(imageUri);

            }
        }
    }

}