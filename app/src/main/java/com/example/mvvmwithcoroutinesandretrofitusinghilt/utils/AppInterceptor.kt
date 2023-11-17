package com.example.mvvmwithcoroutinesandretrofitusinghilt.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor (private val context: Context) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
     //   val token: String = "Bearer "+ getPreference(AppConstant.ConstantVar.BEARER_TOKEN,"")

        val headers =
              //  if (token != null) {
//            request.headers.newBuilder()
//                .add("Content-Type", "application/json")
//                .add("Accept", "application/json")
//               // .add("Authorization", token)
//                /*.add(
//                    "secret_key",
//                    "sk_NdsOII/5QcITWtpGE4HIN44bxw73KY91g3F1StfuM9vFnuAwHH3itkPVM0pzLU0="
//                )
//                .add(
//                    "publish_key",
//                    "pk_lljrSoY+Po3LCumUqGHfrE+rZ1pqtcbB6UTExWl/gVIQ2qGE4gMSOak0mqUzbfiq"
//                )*/
//                .build()
//        }
        //else {
           request.headers.newBuilder()
                .add("Content-Type", "application/json")
                .add("Accept", "application/json")
                /* .add(
                     "secret_key",
                     "sk_NdsOII/5QcITWtpGE4HIN44bxw73KY91g3F1StfuM9vFnuAwHH3itkPVM0pzLU0="
                 )
                 .add(
                     "publish_key",
                     "pk_lljrSoY+Po3LCumUqGHfrE+rZ1pqtcbB6UTExWl/gVIQ2qGE4gMSOak0mqUzbfiq"
                 )*/
                .build()
    //    }
        request = request.newBuilder().headers(headers).build()
        return chain.proceed(request)
    }
}