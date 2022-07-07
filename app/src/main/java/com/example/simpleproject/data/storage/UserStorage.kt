package com.example.simpleproject.data.storage

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}