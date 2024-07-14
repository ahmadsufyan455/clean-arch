package com.zerodev.diexample.view.viewmodel.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zerodev.diexample.data.models.Story
import com.zerodev.diexample.domain.interactor.GetStoryInteractor
import com.zerodev.diexample.domain.usecase.GetStory

class MainViewModel(private val getStory: GetStory) : ViewModel() {
    private val _story = MutableLiveData<Story>()

    fun getStory(): LiveData<Story> {
        _story.value = getStory.execute()
        return _story
    }
}