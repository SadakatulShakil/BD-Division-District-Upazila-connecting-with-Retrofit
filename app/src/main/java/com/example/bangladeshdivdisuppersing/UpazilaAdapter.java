package com.example.bangladeshdivdisuppersing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangladeshdivdisuppersing.Model.UpazilaData;

import java.util.ArrayList;

public class UpazilaAdapter extends RecyclerView.Adapter<UpazilaAdapter.viewHolder> {

    private Context context;
    private ArrayList<UpazilaData>upazilaArrayList;

    public UpazilaAdapter(Context context, ArrayList<UpazilaData>upazilaArrayList) {
        this.context = context;
        this.upazilaArrayList = upazilaArrayList;
    }


    @NonNull
    @Override
    public UpazilaAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.div_list,parent,false);


        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UpazilaAdapter.viewHolder holder, int position) {
        final UpazilaData currentUp = upazilaArrayList.get(position);

        String upazilaName = currentUp.getName();
        holder.nameTV.setText(upazilaName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpazilaDetailsActivity.class);
                intent.putExtra("Upazila",currentUp);
                context.startActivity(intent);
                Toast.makeText(context, "Data " + currentUp.getUrl(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return upazilaArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.NameTV);
        }
    }
}
