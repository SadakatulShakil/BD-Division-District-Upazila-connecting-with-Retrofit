package com.example.bangladeshdivdisuppersing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bangladeshdivdisuppersing.Model.DivisionData;
import com.example.bangladeshdivdisuppersing.Model.Division;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";
    private Spinner divSpinner, DisSpinner, UpSpinner;



    private DivisionAdapter myDivAdapter;
    private DistrictAdapter myDisAdapter;
    private UpazilaAdapter myUpAdapter;

    private RecyclerView recyclerView;

    private ArrayList<DivisionData> mydivDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.marvelItemsRecView);
        mydivDataList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myDivAdapter = new DivisionAdapter(MainActivity.this, mydivDataList);
        recyclerView.setAdapter(myDivAdapter);

        loadDivisionData();

    }

    private void loadDivisionData() {

        Retrofit retrofit = Retrofitclient.getRetrofitClient();
        Api api = retrofit.create(Api.class);
        Call<List<Division>> call = api.getByDivisions();

        call.enqueue(new Callback<List<Division>>() {
            @Override
            public void onResponse(Call<List<Division>> call, Response<List<Division>> response) {
                if (response.code() == 200) {
                    List<Division> divisions = response.body();

                    mydivDataList.addAll(divisions.get(2).getData());

                    Log.d(TAG, "onResponse: ok "+mydivDataList.size());

                    //myDivisionList.addAll(divisions);
                    myDivAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Division>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
