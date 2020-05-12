package com.example.ptice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import android.os.Looper
import android.os.SystemClock
import androidx.lifecycle.LiveData


class LiveDataCounterViewModel : ViewModel(){

    var counterViewModel: LiveData<String> = MutableLiveData()

}