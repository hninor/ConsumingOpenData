package com.example.hnino.consumingopendata;

import com.example.hnino.consumingopendata.entities.CultivoIlicito;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hnino on 27/11/2017.
 */

public interface MyApiEndPointInterface {


    @GET("b87i-ixkv.json")
    Call<List<CultivoIlicito>> getCrops(@Query("departamento") String departamento,
                                        @Query("municipio") String municipio,
                                        @Query("$where") String where,
                                        @Query("$limit") String limit);
}
