package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpViewModel()
        initView()

    }

    private fun setUpViewModel() {
        viewModelFactory = MainViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun initView() {
        binding.countText.text = viewModel.getCurrentCount().toString()

        binding.btnCount.setOnClickListener {
            binding.countText.text = viewModel.getUpdateCount().toString()
        }

        binding.btnReset.setOnClickListener {
            binding.countText.text = viewModel.resetCount().toString()
        }
    }
}