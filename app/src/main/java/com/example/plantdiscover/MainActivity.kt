package com.example.plantdiscover

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

//    private val API_KEY = ""

//    private val BASE_URL: String = "https://trefle.io/"

//    private lateinit var retrofit: Retrofit
    private  var myFirstRecyclerView: RecyclerView? = null
//    nullprivate val plants:List<User>
//        get() {
//            TODO()
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    d("plant", "onResponse: ${response.body()!![0].name}")
                    showData(response.body()!! )
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    d("plant", "onFail")
                }
            })


//        val plants = mutableListOf<User>()
//        for (i in 0..10) {
//            plants.add(
//                User(0,0,"Anna", "anka@gmail.com","Lubie spać i tatuaże"
//                )
//            )
//        }

//        myFirstRecyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = AdapterPlant(plants)
//        }
    }

    private fun showData(plants: List<User>) {
        val myFirstRecyclerView = findViewById<RecyclerView>(R.id.myFirstRecyclerView)
        myFirstRecyclerView.apply { layoutManager = LinearLayoutManager(this@MainActivity)
        adapter=AdapterPlant(plants )}

    }
}