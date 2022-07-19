package com.rafael.ioasys_book.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafael.ioasys_book.domain.usecase.LoginUseCase
import com.rafael.ioasys_book.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<String>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<String>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2_000)

            try {
                loginUseCase(
                    params = LoginUseCase.Params(
                        email = email,
                        password = password
                    )
                ).collect { user ->
                    user.apply {
                        if (name.isNotEmpty() && password.isNotEmpty()) {
                            _loggedUserViewState.postSuccess(user.accessToken)
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