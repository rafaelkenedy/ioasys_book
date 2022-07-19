package com.rafael.ioasys_book.domain.usecase

import com.rafael.ioasys_book.domain.exception.InvalidEmailException
import com.rafael.ioasys_book.domain.model.User
import com.rafael.ioasys_book.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    operator fun invoke(params: Params): Flow<User> = when {
        params.email.isEmpty() -> throw InvalidEmailException()
        params.password.isEmpty() -> throw InvalidEmailException()
        else -> {
            loginRepository.login(
                email = params.email,
                password = params.password
            )
        }
    }

    data class Params(
        val email: String,
        val password: String,
    )
}