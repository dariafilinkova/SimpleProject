package com.example.simpleproject.domain.usecase

import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(parameters: SaveUserNameParameters): Boolean {
        return userRepository.saveName(saveParam = parameters)
    }

}