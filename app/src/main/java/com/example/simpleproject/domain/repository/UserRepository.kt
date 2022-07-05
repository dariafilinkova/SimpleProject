package com.example.simpleproject.domain.repository

import com.example.simpleproject.domain.models.SaveUserNameParameters
import com.example.simpleproject.domain.models.UserName

interface UserRepository {
     fun saveName(saveParam:SaveUserNameParameters) : Boolean
     fun getName():UserName
}