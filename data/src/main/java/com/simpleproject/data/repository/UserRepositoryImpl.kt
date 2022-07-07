package com.simpleproject.data.repository

import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.repository.UserRepository
import com.simpleproject.data.storage.User
import com.simpleproject.data.storage.UserStorage



class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParameters): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParameters): User{
        return User(firstName = saveParam.name, secondName = "")
    }

    private fun mapToDomain(user: User) : UserName{
        return UserName(firstName = user.firstName, secondName = user.secondName)
    }
}