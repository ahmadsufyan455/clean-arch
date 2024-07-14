package com.zerodev.diexample.domain.interactor

import com.zerodev.diexample.data.models.User
import com.zerodev.diexample.domain.repositories.UserRepository
import com.zerodev.diexample.domain.usecase.GetUser

class GetUserInteractor(private val userRepository: UserRepository): GetUser {
    override fun execute(): User {
        return userRepository.getUser()
    }
}