package com.example.mvvmwithcoroutinesandretrofitusinghilt.models

class QuotesResponse : ArrayList<QuotesResponse.QuotesResponseItem>(){

    data class QuotesResponseItem(
        val author: String,
        val text: String)
}