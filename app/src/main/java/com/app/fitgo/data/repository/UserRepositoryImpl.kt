package com.app.fitgo.data.repository

import com.app.fitgo.data.database.UserDao
import com.app.fitgo.domain.model.UserData
import com.app.fitgo.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
): UserRepository{

    override suspend fun insertUserData(userData: UserData) {
        return userDao.insertUserData(userData)
    }

    override suspend fun updateUserData(userData: UserData) {
        return userDao.updateUserData(userData)
    }

    override fun getUsers(): List<UserData> {
       return userDao.getUsers()
    }

    override suspend fun deleteById(id: String) {
        userDao.deleteById(id)
    }
}