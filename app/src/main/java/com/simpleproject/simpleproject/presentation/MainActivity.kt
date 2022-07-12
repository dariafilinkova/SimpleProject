package com.simpleproject.simpleproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simpleproject.simpleproject.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.resultLive.observe(this, {
            binding.dataTextView.text = it
        })

        binding.saveDataButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            viewModel.save(text)
        }
        binding.getDataButton.setOnClickListener {
            viewModel.load()
        }
    }
}