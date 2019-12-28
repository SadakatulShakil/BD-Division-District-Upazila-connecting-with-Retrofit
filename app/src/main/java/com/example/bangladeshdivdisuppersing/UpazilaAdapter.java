package com.example.bangladeshdivdisuppersing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangladeshdivdisuppersing.Model.District;
import com.example.bangladeshdivdisuppersing.Model.Upazila;

import java.util.ArrayList;

public class UpazilaAdapter extends RecyclerView.Adapter<UpazilaAdapter.viewHolder> {

    private Context context;
    private ArrayList<Upazila>upazilaArrayList;

    public UpazilaAdapter(Context context,  ArrayList<Upazila>upazilaArrayList) {
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
