package com.zerodev.diexample.view.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zerodev.diexample.data.models.User
import com.zerodev.diexample.domain.interactor.GetUserInteractor
import com.zerodev.diexample.domain.usecase.GetUser

class UserViewModel(private val getUser: GetUser) : ViewModel() {
    private val _user = MutableLiveData<User>()
    fun getUser(): LiveData<User> {
        _user.value = getUser.execute()
        return _user
    }
}