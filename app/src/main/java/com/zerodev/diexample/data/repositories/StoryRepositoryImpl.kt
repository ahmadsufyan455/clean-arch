package com.zerodev.diexample.data.repositories

import com.zerodev.diexample.data.datasources.LocalDataSource
import com.zerodev.diexample.data.models.Story
import com.zerodev.diexample.domain.repositories.StoryRepository

class StoryRepositoryImpl(private val localDataSource: LocalDataSource) : StoryRepository {
    override fun getStory(): Story {
        return localDataSource.getStory()
    }
}