package com.example.plantdiscover

import com.example.plantdiscover.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("species?token=" + BuildConfig.YOUR_TREFLE_TOKEN)
    fun fetchSpecies(): Call<Data>

    @GET("https://trefle.io/api/v1/plants/search?token="+BuildConfig.YOUR_TREFLE_TOKEN+"&q="+ "coconut")
    fun searchCoconut(): Call<Data>
}