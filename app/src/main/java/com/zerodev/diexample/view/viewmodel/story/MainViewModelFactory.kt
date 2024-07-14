package com.zerodev.diexample.view.viewmodel.story

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zerodev.diexample.di.Injection
import com.zerodev.diexample.domain.interactor.GetStoryInteractor
import com.zerodev.diexample.domain.usecase.GetStory

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private var getStory: GetStory): ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideStoryUseCase())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(getStory) as T
            else -> throw IllegalArgumentException("unknown viewmodel class: ${modelClass.name}")
        }
    }
}