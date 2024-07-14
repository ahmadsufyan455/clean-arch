package com.zerodev.diexample.domain.interactor

import com.zerodev.diexample.data.models.Story
import com.zerodev.diexample.domain.repositories.StoryRepository
import com.zerodev.diexample.domain.usecase.GetStory

class GetStoryInteractor(private val storyRepository: StoryRepository) : GetStory {
    override fun execute(): Story {
        return storyRepository.getStory()
    }
}