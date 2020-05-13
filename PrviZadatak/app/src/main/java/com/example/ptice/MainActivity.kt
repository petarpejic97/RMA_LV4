package com.example.ptice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ptice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProviders



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel : BirdCounterViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(BirdCounterViewModel::class.java)

        setUpUI()

        viewModel.counter.observe(this,androidx.lifecycle.Observer {
            binding.invalidateAll()
        })

    }

    private fun setUpUI(){
        if(viewModel.counter.value == null ){
            viewModel.counter.value = 0
        }
        if(viewModel.background.value == null ){
            viewModel.background.value = R.color.colorTransparent
        }
        binding.apply {
            bird = viewModel
            binding.blueColor.setOnClickListener { saveColorAndIncrement(R.color.colorBlue) }
            binding.greenColor.setOnClickListener { saveColorAndIncrement(R.color.colorPrimary) }
            binding.greyColor.setOnClickListener { saveColorAndIncrement(R.color.colorGray) }
            binding.brownColor.setOnClickListener { saveColorAndIncrement(R.color.colorBrown) }
            binding.reset.setOnClickListener { resetCounterAndColor(R.color.colorTransparent) }
        }
    }

    private fun saveColorAndIncrement(color : Int){
        setColor(color)
        incrementNumber()
    }

    private fun setColor(color:Int){
        viewModel.background.value= color
    }
    private fun incrementNumber() {
        var number = viewModel.counter.value
        if (number != null) {
            viewModel.counter.value = number+1
        }
    }
    private fun resetCounterAndColor(color : Int){
        setColor(color)
        binding.bird?.counter?.value = 0
    }

}
