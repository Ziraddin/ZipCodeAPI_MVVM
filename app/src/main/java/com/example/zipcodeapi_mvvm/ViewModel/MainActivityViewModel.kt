package com.example.zipcodeapi_mvvm.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zipcodeapi_mvvm.Model.ZipDTO
import com.example.zipcodeapi_mvvm.Retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {

    var result = MutableLiveData<ZipDTO?>()

    fun getData(path: Int, context: Context) {
        RetrofitInstance.instance.getData(path)?.enqueue(object : Callback<ZipDTO?> {
            override fun onResponse(call: Call<ZipDTO?>, response: Response<ZipDTO?>) {
                result.postValue(response.body())
            }

            override fun onFailure(call: Call<ZipDTO?>, t: Throwable) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun observeResult(): MutableLiveData<ZipDTO?> {
        return result
    }
}