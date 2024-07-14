package com.zerodev.diexample.domain.usecase

import com.zerodev.diexample.data.models.Story

interface GetStory {
    fun execute(): Story
}