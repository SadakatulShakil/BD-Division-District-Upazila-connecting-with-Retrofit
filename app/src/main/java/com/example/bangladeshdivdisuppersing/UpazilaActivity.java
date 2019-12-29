package com.example.bangladeshdivdisuppersing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.bangladeshdivdisuppersing.Model.DistrictData;
import com.example.bangladeshdivdisuppersing.Model.UpazilaData;
import com.example.bangladeshdivdisuppersing.Model.Upazila;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UpazilaActivity extends AppCompatActivity {
    public static final String TAG ="Upazila";
    private DistrictData district;
    private ArrayList<UpazilaData> upazilaList;
    private ArrayList<UpazilaData> currentUpazilaList = new ArrayList<>();
    String disId;
    private RecyclerView recyclerView;
    private UpazilaData upazila;

    private UpazilaAdapter myUpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upazila);

        upazilaList = new ArrayList<>();

        Intent intent = getIntent();
        district = intent.getExtras().getParcelable("district");
        disId = district.getId();

        recyclerView = findViewById(R.id.marvelItemsRecView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myUpAdapter = new UpazilaAdapter(UpazilaActivity.this, currentUpazilaList);
        recyclerView.setAdapter(myUpAdapter);

        loadUpazilaData();
    }

    private void loadUpazilaData() {

        Retrofit retrofit = Retrofitclient.getRetrofitClient();

        Api api = retrofit.create(Api.class);

        Call<List<Upazila>> call = api.getByUpazilas();

        call.enqueue(new Callback<List<Upazila>>() {
            @Override
            public void onResponse(Call<List<Upazila>> call, Response<List<Upazila>> response) {
                if(response.code() == 200){
                    List<Upazila> upazilas = response.body();//////get All Upazilas////
                    upazilaList.addAll(upazilas.get(2).getData());//////get All Upazilas////

                    addCurrentUpazila(upazilaList);
                    myUpAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Upazila>> call, Throwable t) {

            }
        });
    }

    private void addCurrentUpazila(ArrayList<UpazilaData> allUpazilaList) {
        for(int i=0; i< allUpazilaList.size(); i++){
            upazila = allUpazilaList.get(i);
            if(disId.equals(upazila.getDistrictId())){
                currentUpazilaList.add(upazila);
            }
        }
    }
}
