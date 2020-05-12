package com.example.ptice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterViewModelFactory(private val counter: String) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BirdCounterViewModel::class.java)) {
            return BirdCounterViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}