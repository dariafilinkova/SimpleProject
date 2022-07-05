package com.example.simpleproject.data.repository

import android.content.Context
import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName
import com.example.simpleproject.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_SECOND_NAME = "second_name"
private const val DEFAULT_NAME = "Default"


class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParameters): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: " "
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, secondName = secondName)
    }
}