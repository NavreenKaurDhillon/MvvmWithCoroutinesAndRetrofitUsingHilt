package com.example.mvvmwithcoroutinesandretrofitusinghilt.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcoroutinesandretrofitusinghilt.R
import com.example.mvvmwithcoroutinesandretrofitusinghilt.common.BaseApplication
import com.example.mvvmwithcoroutinesandretrofitusinghilt.genericdatacontainer.Resource
import com.example.mvvmwithcoroutinesandretrofitusinghilt.models.QuotesResponse
import com.example.mvvmwithcoroutinesandretrofitusinghilt.viewmodel.MainViewModel
import com.example.mvvmwithcoroutinesandretrofitusinghilt.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val appViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQuotes()

    }

    private fun getQuotes() {
        appViewModel.getQuotesList().observe(this, quotesObserver)
    }

    val quotesObserver = Observer<Resource<QuotesResponse>>{
        when(it.status){
            Resource.Status.SUCCESS -> {
                android.util.Log.d(TAG, "  success  : "+it.data)
            }
            Resource.Status.ERROR -> {
                android.util.Log.d(TAG, "  error  : "+it.data)

            }
            Resource.Status.LOADING -> {}
        }
    }
}