package com.example.bangladeshdivdisuppersing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangladeshdivdisuppersing.Model.Division;

import java.util.ArrayList;

public class DivisionAdapter extends RecyclerView.Adapter<DivisionAdapter.viewHolder> {

    private Context context;
    private ArrayList<Division>divisionArrayList;

    public DivisionAdapter(Context context, ArrayList<Division> divisionArrayList) {
        this.context = context;
        this.divisionArrayList = divisionArrayList;
    }


    @NonNull
    @Override
    public DivisionAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.div_list,parent,false);


        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DivisionAdapter.viewHolder holder, int position) {

        final Division currentDiv = divisionArrayList.get(position);

        String stringName = currentDiv.getData().get(0).getName();

        holder.nameTV.setText(stringName);
    }

    @Override
    public int getItemCount() {
        return divisionArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.NameTV);
        }
    }
}
