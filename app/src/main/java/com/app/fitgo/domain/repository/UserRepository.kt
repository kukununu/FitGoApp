package com.app.fitgo.domain.repository

import com.app.fitgo.domain.model.UserData

interface UserRepository {
    suspend fun insertUserData(userData: UserData)
    suspend fun updateUserData(userData: UserData)
    fun getUsers(): List<UserData>
    suspend fun deleteById(id: String)
}