package com.simpleproject.simpleproject.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.usecase.GetUserNameUseCase
import com.example.simpleproject.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    //by lazy - создадим эти классы только в тот момент,когда они нам понадобятся
// (то есть тогда когда мы будем обращать к этой переменной ниже в коде)

    private val _resultLive = MutableLiveData<String>()
    val resultLive : LiveData<String> = _resultLive //активити не имеет право изменять лайфдату,только подписываться

    init {
        Log.e("a", "ViewModel")
    }

    fun save(text: String) {
        val parameters = SaveUserNameParameters(text)
        val resultData =
            saveUserNameUseCase.execute(parameters = parameters)
        _resultLive.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        _resultLive.value = "${userName.firstName} ${userName.secondName}"
    }
}