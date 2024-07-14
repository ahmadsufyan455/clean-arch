package com.zerodev.diexample.domain.repositories

import com.zerodev.diexample.data.models.User

interface UserRepository {
    fun getUser(): User
}