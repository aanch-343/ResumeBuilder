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

import java.util.ArrayList;

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.ViewHolder> {
    Context context;
    ArrayList<ExperienceModel> experienceModelArrayList;
    RecyclerAdapter3(Context context, ArrayList<ExperienceModel> experienceModelArrayList){
        this.context=context;
        this.experienceModelArrayList=experienceModelArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.activity_experience,parent,false);
        ViewHolder viewh=new ViewHolder(view);
        return viewh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtcname.setText(experienceModelArrayList.get(position).cname);
        holder.txtjob.setText(experienceModelArrayList.get(position).job);
        holder.txtdur.setText(experienceModelArrayList.get(position).dur);
        //holder.txtdetail.setText(experienceModelArrayList.get(position).detail);
        final int itemPosition = position;
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= itemPosition;
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.addexperience);
                EditText edtcname=dialog.findViewById(R.id.edtcname);
                EditText edtjob=dialog.findViewById(R.id.edtJtitle);
                EditText edtdur=dialog.findViewById(R.id.edtDur);
               // EditText edtdetail=dialog.findViewById(R.id.edtdetail);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setText("Update");
                TextView txtTitle=dialog.findViewById(R.id.textView);
                txtTitle.setText("UPDATE DETAILS");
               edtcname.setText((experienceModelArrayList.get(position)).cname);
               edtjob.setText((experienceModelArrayList.get(position)).job);
                edtdur.setText((experienceModelArrayList.get(position)).dur);
               // edtdetail.setText((experienceModelArrayList.get(position)).detail);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cname=edtcname.getText().toString();
                        String job=edtjob.getText().toString();
                        String dur=edtdur.getText().toString();
                        //String detail=edtdetail.getText().toString();
                     experienceModelArrayList.set(position,new ExperienceModel(cname,job,dur));
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
                                experienceModelArrayList.remove(position);
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
        return experienceModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtcname,txtjob,txtdur;
        LinearLayout llrow;

        public ViewHolder( @NonNull View itemView) {
            super(itemView);
            txtcname=itemView.findViewById(R.id.cname);
            txtjob=itemView.findViewById(R.id.job);
            txtdur=itemView.findViewById(R.id.dur);
            //txtdetail=itemView.findViewById(R.id.detail);
            llrow=itemView.findViewById(R.id.llrow);

        }
    }
}
