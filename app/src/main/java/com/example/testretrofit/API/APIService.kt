package com.example.testretrofit.API

import com.example.testretrofit.model.TotalData
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/world/total")
    fun getDataCountry(): Call<TotalData?>?
}