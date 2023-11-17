package com.example.mvvmwithcoroutinesandretrofitusinghilt.repositories

import com.example.mvvmwithcoroutinesandretrofitusinghilt.genericdatacontainer.Resource
import com.example.mvvmwithcoroutinesandretrofitusinghilt.genericdatacontainer.ResponseHandler
import com.example.mvvmwithcoroutinesandretrofitusinghilt.models.QuotesResponse
import com.example.mvvmwithcoroutinesandretrofitusinghilt.networking.ApiInterface
import javax.inject.Inject

class MainRepository@Inject constructor(
    private val apiInterface: ApiInterface,
    private val responseHandler: ResponseHandler
) {

    suspend fun getQuotesList(): Resource<QuotesResponse> {
       return try {
           responseHandler.handleResponse(apiInterface.getQuotesList())
        }
        catch (e : Exception){
            responseHandler.handleException(e)
        }

    }
}