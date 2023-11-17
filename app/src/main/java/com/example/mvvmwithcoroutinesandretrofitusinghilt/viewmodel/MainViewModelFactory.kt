package com.example.mvvmwithcoroutinesandretrofitusinghilt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcoroutinesandretrofitusinghilt.repositories.MainRepository

class MainViewModelFactory(private val mainRepository: MainRepository) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(mainRepository) as T
    }
}