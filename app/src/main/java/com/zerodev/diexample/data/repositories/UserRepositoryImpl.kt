package com.zerodev.diexample.data.repositories

import com.zerodev.diexample.data.datasources.LocalDataSource
import com.zerodev.diexample.data.models.User
import com.zerodev.diexample.domain.repositories.UserRepository

class UserRepositoryImpl(private val localDataSource: LocalDataSource) : UserRepository {
    override fun getUser(): User {
        return localDataSource.getUser()
    }
}