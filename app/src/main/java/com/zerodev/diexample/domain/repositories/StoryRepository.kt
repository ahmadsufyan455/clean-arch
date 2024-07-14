package com.zerodev.diexample.domain.repositories

import com.zerodev.diexample.data.models.Story

interface StoryRepository {
    fun getStory(): Story
}