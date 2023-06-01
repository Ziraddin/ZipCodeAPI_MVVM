package com.example.zipcodeapi_mvvm.Retrofit

import com.example.zipcodeapi_mvvm.API.ZipApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val instance = Retrofit.Builder()
        .baseUrl("https://ziptasticapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ZipApi::class.java)
}