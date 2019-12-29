package com.example.bangladeshdivdisuppersing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangladeshdivdisuppersing.Model.DatumDis;
import com.example.bangladeshdivdisuppersing.Model.District;
import com.example.bangladeshdivdisuppersing.Model.Division;

import java.util.ArrayList;

public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.viewHolder> {

    private Context context;
    private ArrayList<DatumDis>districtArrayList;

    public DistrictAdapter(Context context, ArrayList<DatumDis> districtArrayList) {
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

        final DatumDis currentDis = districtArrayList.get(position);

        String districtName = currentDis.getName();
        holder.nameTV.setText(districtName);

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
