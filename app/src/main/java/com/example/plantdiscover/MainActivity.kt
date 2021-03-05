package com.example.plantdiscover

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantdiscover.model.Data
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://trefle.io")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)

        api.filterOnASingleValue().enqueue(object : Callback<List<Data>> {

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                d("plant", "onResponse: ${response.body()!![0].commonName}")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                d("plant", "onFail")
            }
        })


        val myFirstRecyclerView = findViewById<RecyclerView>(R.id.myFirstRecyclerView)
        val plants = mutableListOf<Data>()
        for (i in 0..10) {
            plants.add(
                Data(
                    "Monstera",
                    "Monsterouses",
                    "https://cdn.shopify.com/s/files/1/0207/8508/products/monstera_960x.jpg?v=1568651988"
                )
            )
        }
        myFirstRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AdapterPlant(plants)
        }
    }

    private fun showData(body: List<Data>) {

    }
}