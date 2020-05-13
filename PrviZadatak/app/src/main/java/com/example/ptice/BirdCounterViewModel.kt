package com.example.ptice

import android.graphics.Color
import androidx.databinding.InverseMethod
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirdCounterViewModel : ViewModel() {
    var counter =  MutableLiveData<Int>()
    var background = MutableLiveData<Int>()


}