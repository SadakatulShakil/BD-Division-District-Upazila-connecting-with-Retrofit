package com.example.bangladeshdivdisuppersing;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bangladeshdivdisuppersing.Model.DatumDis;
import com.example.bangladeshdivdisuppersing.Model.DatumDiv;
import com.example.bangladeshdivdisuppersing.Model.DatumUp;
import com.example.bangladeshdivdisuppersing.Model.Division;

import java.util.ArrayList;
import java.util.List;

public class DivisionAdapter extends RecyclerView.Adapter<DivisionAdapter.viewHolder> {

    private Context context;
    private ArrayList<DatumDiv>divisionArrayList;

    public DivisionAdapter(Context context, ArrayList<DatumDiv> divisionArrayList) {
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

        final DatumDiv currentDiv = divisionArrayList.get(position);

        String divisionName = currentDiv.getName();

        holder.nameTV.setText(divisionName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DistrictActivity.class);
                intent.putExtra("division", (Parcelable) currentDiv);
                context.startActivity(intent);
                Toast.makeText(context, "data" + currentDiv.toString(), Toast.LENGTH_SHORT).show();

            }
        });
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
