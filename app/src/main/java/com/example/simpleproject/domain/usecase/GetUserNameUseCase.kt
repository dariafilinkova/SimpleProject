package com.example.simpleproject.domain.usecase

import com.example.simpleproject.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "Daria", secondName = "Bunny")
    }
}