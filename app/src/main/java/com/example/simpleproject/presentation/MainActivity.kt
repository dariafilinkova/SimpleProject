package com.example.simpleproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleproject.data.repository.UserRepositoryImpl
import com.example.simpleproject.data.storage.SharedPrefsUserStorage
import com.example.simpleproject.databinding.ActivityMainBinding
import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.repository.UserRepository
import com.example.simpleproject.domain.usecase.GetUserNameUseCase
import com.example.simpleproject.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy { UserRepositoryImpl(SharedPrefsUserStorage(applicationContext)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }
//by lazy - создадим эти классы только в тот момент,когда они нам понадобятся
// (то есть тогда когда мы будем обращать к этой переменной ниже в коде)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveDataButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            val result =
                saveUserNameUseCase.execute(parameters = SaveUserNameParameters(text))
            binding.dataTextView.text = "Save result = $result"
        }
        binding.getDataButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.secondName}"
        }
    }
}