package com.simpleproject.simpleproject.di

import com.example.simpleproject.domain.usecase.GetUserNameUseCase
import com.example.simpleproject.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}