package com.simpleproject.simpleproject.di

import com.example.simpleproject.domain.repository.UserRepository
import com.simpleproject.data.repository.UserRepositoryImpl
import com.simpleproject.data.storage.SharedPrefsUserStorage
import com.simpleproject.data.storage.UserStorage
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}