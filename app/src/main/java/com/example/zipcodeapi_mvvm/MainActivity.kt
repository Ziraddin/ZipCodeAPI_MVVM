package com.example.zipcodeapi_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.example.zipcodeapi_mvvm.ViewModel.MainActivityViewModel
import com.example.zipcodeapi_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.submitBTN.setOnClickListener {
            if (binding.zipcodeET.text.toString().trim().equals("")) {
                Toast.makeText(this, "Please enter a Zip Code!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.getData(binding.zipcodeET.text.toString().toInt(), this)
            }

        }

        viewModel.observeResult().observe(this, Observer { it ->
            if (it?.error == null) {
                binding.CountryTV.setText(it?.country)
                binding.StateTV.setText(it?.state)
                binding.CityTV.setText(it?.city)
            } else if (it?.error == "Zip Code not found!") {
                Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Api request failed!", Toast.LENGTH_SHORT).show()
            }
        })
    }

}