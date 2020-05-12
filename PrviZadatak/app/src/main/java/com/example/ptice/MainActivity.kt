package com.example.ptice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ptice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel : BirdCounterViewModel

    private lateinit var viewModelFactory: CounterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setUpUI()

    }

    private fun setUpUI(){
        binding.blueColor.setOnClickListener { saveColorAndIncrement(R.color.colorBlue) }
        binding.greenColor.setOnClickListener { saveColorAndIncrement(R.color.colorPrimary) }
        binding.greyColor.setOnClickListener { saveColorAndIncrement(R.color.colorGray) }
        binding.brownColor.setOnClickListener { saveColorAndIncrement(R.color.colorBrown) }
        binding.reset.setOnClickListener { resetCounterAndColor(R.color.colorTransparent) }

        viewModel = ViewModelProviders.of(this).get(BirdCounterViewModel::class.java)

        binding.bird = viewModel
    }
    private fun saveColorAndIncrement(color : Int){
        setColor(color)
        incrementNumber()
    }

    private fun setColor(color:Int){
        binding.bird?.background = color
    }
   private fun incrementNumber() {
        var counter = viewModel.counter.toInt()
        counter++
        viewModel.counter = counter.toString()
        refreshUI()
    }
    private fun refreshUI() {
        binding.invalidateAll()
    }
    private fun resetCounterAndColor(color : Int){
        setColor(color)
        binding.bird?.counter = "0"
        refreshUI()
        birdCounter.setBackgroundColor(Color.TRANSPARENT)
    }

}
