package com.example.simpleproject.domain.usecase

import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}