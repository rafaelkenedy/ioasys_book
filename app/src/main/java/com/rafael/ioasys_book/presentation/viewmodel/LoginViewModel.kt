package com.rafael.ioasys_book.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafael.ioasys_book.domain.repositories.LoginRepository
import com.rafael.ioasys_book.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2_000)

            try {
                loginRepository.login(email, password).collect { user ->
                    user.apply {
                        if (name.isNotEmpty() && password.isNotEmpty()) {
                            _loggedUserViewState.postSuccess(true)
                        } else {
                            _loggedUserViewState.postError(Exception(""))
                        }
                    }
                }
            } catch (err: Exception) {
                _loggedUserViewState.postError(err)
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}