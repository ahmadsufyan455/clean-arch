package com.zerodev.diexample.data.datasources

import com.zerodev.diexample.data.models.Story
import com.zerodev.diexample.data.models.User

interface LocalDataSource {
    fun getStory(): Story
    fun getUser(): User
}

class LocalDataSourceImpl : LocalDataSource {
    override fun getStory(): Story {
        return Story(
            id = "1",
            name = "Dicoding",
            description = "Decode idea discover potential",
            photoUrl = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/commons/homepage-hero.png"
        )
    }

    override fun getUser(): User {
        return User(
            id = "abc",
            name = "Dicoding",
            email = "dicoding@gmail.com"
        )
    }
}