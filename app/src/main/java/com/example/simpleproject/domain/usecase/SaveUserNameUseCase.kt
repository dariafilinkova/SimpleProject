package com.example.simpleproject.domain.usecase

import com.example.simpleproject.domain.models.SaveUserNameParameters

class SaveUserNameUseCase {
    //    fun execute(parameters: SaveUserNameParameters): Boolean {
//        return if (parameters.name.isEmpty()) false
//        else true
//    }
    fun execute(parameters: SaveUserNameParameters) = parameters.name.isNotEmpty()
}