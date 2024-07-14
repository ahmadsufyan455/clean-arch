package com.zerodev.diexample.view.viewmodel.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zerodev.diexample.di.Injection
import com.zerodev.diexample.domain.interactor.GetUserInteractor
import com.zerodev.diexample.domain.usecase.GetUser

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private var getUser: GetUser) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: UserViewModelFactory? = null

        fun getInstance(): UserViewModelFactory = instance ?: synchronized(this) {
            instance ?: UserViewModelFactory(Injection.provideUserUseCase())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserViewModel::class.java) -> UserViewModel(getUser) as T
            else -> throw IllegalArgumentException("unknown viewmodel class: ${modelClass.name}")
        }
    }
}