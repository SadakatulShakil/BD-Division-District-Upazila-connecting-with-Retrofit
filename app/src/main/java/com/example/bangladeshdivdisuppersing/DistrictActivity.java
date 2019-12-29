package com.example.bangladeshdivdisuppersing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bangladeshdivdisuppersing.Model.DistrictData;
import com.example.bangladeshdivdisuppersing.Model.DivisionData;
import com.example.bangladeshdivdisuppersing.Model.District;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DistrictActivity extends AppCompatActivity {
    public static final String TAG ="District";
    private DivisionData division;
    private ArrayList<DistrictData> myDistrictList;
    private RecyclerView recyclerView;
    private DistrictData district;
    String divId;
    private ArrayList<DistrictData> currentDistrict = new ArrayList<>();

    private DistrictAdapter myDisAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        Intent intent = getIntent();
        division = intent.getExtras().getParcelable("division");
        divId = division.getId();

        myDistrictList = new ArrayList<>();

        recyclerView = findViewById(R.id.marvelItemsRecView2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myDisAdapter = new DistrictAdapter(DistrictActivity.this, currentDistrict);
        recyclerView.setAdapter(myDisAdapter);

        loadDistrictData();
    }

    private void loadDistrictData() {

        Retrofit retrofit = Retrofitclient.getRetrofitClient();
        Api api = retrofit.create(Api.class);
        Call<List<District>> call = api.getByDistrict();

        call.enqueue(new Callback<List<District>>() {
            @Override
            public void onResponse(Call<List<District>> call, Response<List<District>> response) {
                if (response.code() == 200) {
                    List<District> districts = response.body();/////get All District//////

                    myDistrictList.addAll(districts.get(2).getData());/////get All District//////

                    Log.d(TAG, "onResponse: ok "+myDistrictList.size());

                    //myDivisionList.addAll(divisions);
                    //myDisAdapter.notifyDataSetChanged();

                    addCurrentDistrict(myDistrictList);
                    myDisAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<District>> call, Throwable t) {
                Toast.makeText(DistrictActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addCurrentDistrict(ArrayList<DistrictData> currentDistrictList) {

        for(int i=0; i<currentDistrictList.size(); i++){
            district = currentDistrictList.get(i);
            if(divId.equals(district.getDivisionId())){
                currentDistrict.add(district);
            }
        }

    }
}
