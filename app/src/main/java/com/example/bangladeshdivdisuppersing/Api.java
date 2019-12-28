package com.example.bangladeshdivdisuppersing;

import com.example.bangladeshdivdisuppersing.Model.District;
import com.example.bangladeshdivdisuppersing.Model.Division;
import com.example.bangladeshdivdisuppersing.Model.Upazila;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("divisions/divisions.json")
    Call<List<Division>> getByDivisions();

    @GET("districts/districts.json")
    Call<List<District>> getByDistrict();

    @GET("upazilas/upazilas.json")
    Call<List<Upazila>> getByUpazilas();
}
