package com.zerodev.diexample.di

import com.zerodev.diexample.data.datasources.LocalDataSource
import com.zerodev.diexample.data.datasources.LocalDataSourceImpl
import com.zerodev.diexample.data.repositories.StoryRepositoryImpl
import com.zerodev.diexample.data.repositories.UserRepositoryImpl
import com.zerodev.diexample.domain.repositories.StoryRepository
import com.zerodev.diexample.domain.repositories.UserRepository
import com.zerodev.diexample.domain.interactor.GetStoryInteractor
import com.zerodev.diexample.domain.interactor.GetUserInteractor
import com.zerodev.diexample.domain.usecase.GetStory
import com.zerodev.diexample.domain.usecase.GetUser

object Injection {
    private fun provideDataSource(): LocalDataSource = LocalDataSourceImpl()

    private fun provideStoryRepository(): StoryRepository {
        val localDataSource = provideDataSource()
        return StoryRepositoryImpl(localDataSource)
    }

    private fun provideUserRepository(): UserRepository {
        val localDataSource = provideDataSource()
        return UserRepositoryImpl(localDataSource)
    }

    fun provideStoryUseCase(): GetStory {
        val storyRepository = provideStoryRepository()
        return GetStoryInteractor(storyRepository)
    }

    fun provideUserUseCase(): GetUser {
        val userRepository = provideUserRepository()
        return GetUserInteractor(userRepository)
    }
}