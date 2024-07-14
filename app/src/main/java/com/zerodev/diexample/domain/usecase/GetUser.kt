package com.zerodev.diexample.domain.usecase

import com.zerodev.diexample.data.models.User

interface GetUser {
    fun execute(): User
}