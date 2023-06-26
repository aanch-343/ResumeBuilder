package com.example.resumebuilder;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.ViewHolder> {
    Context context;
    ArrayList<EducationModel> educationModelArrayList;

    RecyclerAdapter1(Context context, ArrayList<EducationModel> educationModelArrayList) {
        this.context = context;
        this.educationModelArrayList = educationModelArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.activity_education,parent,false);
        ViewHolder viewh=new ViewHolder(view);
        return viewh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtcourse.setText(educationModelArrayList.get(position).course);
        holder.txtschool.setText(educationModelArrayList.get(position).school);
        holder.txtgrade.setText(educationModelArrayList.get(position).grade);
        holder.txtyear.setText(educationModelArrayList.get(position).year);
        final int itemPosition = position;
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= itemPosition;
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.addeducation);
                EditText edtyear=dialog.findViewById(R.id.edtyear);
                EditText edtschool=dialog.findViewById(R.id.edtschool);
                EditText edtcourse=dialog.findViewById(R.id.edtcourse);
                EditText edtgrade=dialog.findViewById(R.id.edtgrade);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setText("Update");
                TextView txtTitle=dialog.findViewById(R.id.textView);
                txtTitle.setText("UPDATE DETAILS");
                edtyear.setText((educationModelArrayList.get(position)).year);
                edtcourse.setText((educationModelArrayList.get(position)).course);
                edtschool.setText((educationModelArrayList.get(position)).school);
                edtgrade.setText((educationModelArrayList.get(position)).grade);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String year=edtyear.getText().toString();
                        String school=edtschool.getText().toString();
                        String grade=edtgrade.getText().toString();
                        String course=edtcourse.getText().toString();
                        educationModelArrayList.set(position,new EducationModel(school,year,course,grade));
                        notifyItemChanged(position);


                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });
        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position= itemPosition;
                AlertDialog.Builder builder=new AlertDialog.Builder(context)
                        .setTitle("Delete Details")
                        .setMessage("Are You Sure You Want to delete")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                educationModelArrayList.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return educationModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtyear,txtgrade,txtschool,txtcourse;
        LinearLayout llrow;

        public ViewHolder( @NonNull View itemView) {
            super(itemView);
            txtcourse=itemView.findViewById(R.id.course);
            txtgrade=itemView.findViewById(R.id.grade);
            txtschool=itemView.findViewById(R.id.school);
            txtyear=itemView.findViewById(R.id.year);
            llrow=itemView.findViewById(R.id.llrow);

        }
    }
}
