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

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {
    Context context;
    ArrayList<SkilllsModel> skillsModelArrayList;
    RecyclerAdapter2(Context context, ArrayList<SkilllsModel> skillsModelArrayList){
        this.context=context;
        this.skillsModelArrayList=skillsModelArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.activity_skillls,parent,false);
        ViewHolder viewh=new ViewHolder(view);
        return viewh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtskill.setText(skillsModelArrayList.get(position).skills);
        final int itemPosition = position;
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= itemPosition;
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.addskill);
                EditText edtskill=dialog.findViewById(R.id.edtskill);
                Button btnaction=dialog.findViewById(R.id.btnAction);
                btnaction.setText("Update");
                TextView txtTitle=dialog.findViewById(R.id.textView);
                txtTitle.setText("UPDATE DETAILS");
                edtskill.setText((skillsModelArrayList.get(position)).skills);
                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String skill=edtskill.getText().toString();
                        skillsModelArrayList.set(position,new SkilllsModel(skill));
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
                                skillsModelArrayList.remove(position);
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
        return skillsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtskill;
        LinearLayout llrow;

        public ViewHolder( @NonNull View itemView) {
            super(itemView);
            txtskill=itemView.findViewById(R.id.skills);
            llrow=itemView.findViewById(R.id.llrow);

        }
    }
}
