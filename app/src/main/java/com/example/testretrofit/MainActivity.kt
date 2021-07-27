package com.example.testretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testretrofit.API.APIService
import com.example.testretrofit.API.APIServiceConstructor
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.model.TotalData
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var service: APIService

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        service = APIServiceConstructor.create(APIService::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.setOnRefreshListener { load() }
        load()
    }

    private fun load() {
        val call = service.getDataCountry()

        call!!.enqueue(object : Callback<TotalData?> {
            override fun onResponse(call: Call<TotalData?>, response: Response<TotalData?>) {
                if (response.body() != null) {
                    binding.root.isRefreshing = false
                    binding.textData.text = response.body().toString()
                }
            }

            override fun onFailure(call: Call<TotalData?>, t: Throwable) {
                binding.root.isRefreshing = false
                Snackbar
                    .make(binding.root, "Что-то пошло не так", Snackbar.LENGTH_LONG)
                    .show()
            }
        })
    }
}
