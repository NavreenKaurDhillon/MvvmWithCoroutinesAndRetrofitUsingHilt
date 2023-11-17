package com.example.mvvmwithcoroutinesandretrofitusinghilt.di

import android.content.Context
import com.example.mvvmwithcoroutinesandretrofitusinghilt.networking.ApiInterface
import com.example.mvvmwithcoroutinesandretrofitusinghilt.utils.ApiConstants
import com.example.mvvmwithcoroutinesandretrofitusinghilt.utils.AppInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(AppComponent::class)
object AppModule {
//  @Provides
//    @Singleton
//    fun providerExecutor(): Executor {
//        return Executors.newSingleThreadExecutor()
//    }

    @Provides
    @Singleton
    fun providerInterceptor(@ApplicationContext context: Context): AppInterceptor {
        return AppInterceptor(context)
    }


    @Provides
    @Singleton
    internal fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = (HttpLoggingInterceptor.Level.BODY)
        okHttpClient.addInterceptor(interceptor)
        okHttpClient.addInterceptor(logInterceptor)
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

//
//    @Singleton
//    @Provides
//    fun provideAudioManager(context: Context): AudioManager {
//        return context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
//    }

    @Singleton
    @Provides
    fun apiInterfaceInstance(retrofit: Retrofit) : ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

}