package com.example.plantdiscover

import com.example.plantdiscover.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("species?token=" + BuildConfig.YOUR_TREFLE_TOKEN)
    fun fetchSpecies(): Call<Data>

    @GET("plants/search?token=" + BuildConfig.YOUR_TREFLE_TOKEN + "&q=")
    fun searchPodcastByTerm(@Query("term") term: String):
            Call<Data>
}