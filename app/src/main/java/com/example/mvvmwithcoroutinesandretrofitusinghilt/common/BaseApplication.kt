package com.example.mvvmwithcoroutinesandretrofitusinghilt.common

import android.app.Application
import android.content.Context
import com.example.mvvmwithcoroutinesandretrofitusinghilt.di.AppComponent
import dagger.hilt.android.HiltAndroidApp
import java.net.Socket


@HiltAndroidApp
class BaseApplication : Application() {

//    companion object{
//        lateinit var appContext: Context
//        var context : BaseApplication?=null
//
//    }
//    private var mSocket: Socket? = null
//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
    }
}