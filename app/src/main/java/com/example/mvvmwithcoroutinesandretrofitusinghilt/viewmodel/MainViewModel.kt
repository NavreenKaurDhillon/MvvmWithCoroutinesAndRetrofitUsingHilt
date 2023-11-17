package com.example.mvvmwithcoroutinesandretrofitusinghilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmwithcoroutinesandretrofitusinghilt.genericdatacontainer.Resource
import com.example.mvvmwithcoroutinesandretrofitusinghilt.models.QuotesResponse
import com.example.mvvmwithcoroutinesandretrofitusinghilt.networking.ApiInterface
import com.example.mvvmwithcoroutinesandretrofitusinghilt.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class MainViewModel(val mainRepository: MainRepository) :ViewModel() {

     fun getQuotesList(): LiveData<Resource<QuotesResponse>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val result = mainRepository.getQuotesList()
            emit(result)
        }

    }

}