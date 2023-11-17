package com.example.mvvmwithcoroutinesandretrofitusinghilt.networking

import com.example.mvvmwithcoroutinesandretrofitusinghilt.models.QuotesResponse
import com.example.mvvmwithcoroutinesandretrofitusinghilt.utils.ApiConstants
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiConstants.GET_QUOTES_LIST)
    suspend fun getQuotesList() : QuotesResponse
}