package com.example.plantdiscover.feature.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantdiscover.AdapterPlant
import com.example.plantdiscover.ApiService
import com.example.plantdiscover.R
import com.example.plantdiscover.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        val apiBaseUrl = "https://trefle.io/api/v1/"

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)
        api.fetchSpecies().enqueue(object : Callback<Data> {

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                Log.d("plant", "onResponse")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("plant", "onFail")
            }
        })
    }

    private fun showData(plants: Data) {
        val myFirstRecyclerView = findViewById<RecyclerView>(R.id.myFirstRecyclerView)
        myFirstRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = plants.data?.let { AdapterPlant(it) }
        }
    }
}