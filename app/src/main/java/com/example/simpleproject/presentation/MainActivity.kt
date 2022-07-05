package com.example.simpleproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleproject.databinding.ActivityMainBinding
import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.usecase.GetUserNameUseCase
import com.example.simpleproject.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveDataButton.setOnClickListener {
//            val text = binding.dataEditText.text.toString()
//            val params = SaveUserNameParameters(name = text)
//            val result : Boolean = saveUserNameUseCase.execute(parameters = params)
            val text = binding.dataEditText.text.toString()
            val result =
                saveUserNameUseCase.execute(parameters = SaveUserNameParameters(text))
            binding.dataTextView.text = "Save result = $result"
        }
        binding.getDataButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text= "${userName.firstName} ${userName.secondName}"
        }
    }
}