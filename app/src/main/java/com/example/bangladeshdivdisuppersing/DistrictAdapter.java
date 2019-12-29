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

import com.example.bangladeshdivdisuppersing.Model.DistrictData;

import java.util.ArrayList;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.viewHolder> {

    private Context context;
    private ArrayList<DistrictData>districtArrayList;

    public DistrictAdapter(Context context, ArrayList<DistrictData> districtArrayList) {
        this.context = context;
        this.districtArrayList = districtArrayList;
    }


    @NonNull
    @Override
    public DistrictAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.div_list,parent,false);


        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DistrictAdapter.viewHolder holder, int position) {

        final DistrictData currentDis = districtArrayList.get(position);

        String districtName = currentDis.getName();
        holder.nameTV.setText(districtName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpazilaActivity.class);
                intent.putExtra("district", currentDis);
                context.startActivity(intent);
                Toast.makeText(context, "data" + currentDis.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return districtArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.NameTV);
        }
    }
}
