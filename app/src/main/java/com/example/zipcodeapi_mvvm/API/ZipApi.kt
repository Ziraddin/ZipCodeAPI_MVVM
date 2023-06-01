package com.example.zipcodeapi_mvvm.API

import com.example.zipcodeapi_mvvm.Model.ZipDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ZipApi {

    @GET("{zipcode}")
    fun getData(@Path("zipcode") zipcode: Int): Call<ZipDTO?>?

}
