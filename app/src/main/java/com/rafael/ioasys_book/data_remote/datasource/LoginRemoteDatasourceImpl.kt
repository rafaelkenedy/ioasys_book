package com.rafael.ioasys_book.data_remote.datasource

import com.rafael.ioasys_book.data.datasource.remote.LoginRemoteDatasource
import com.rafael.ioasys_book.data_remote.mappers.toDomain
import com.rafael.ioasys_book.data_remote.model.LoginRequest
import com.rafael.ioasys_book.data_remote.service.AuthService
import com.rafael.ioasys_book.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDatasourceImpl(
    private val authService: AuthService
) : LoginRemoteDatasource {
    override fun login(email: String, password: String): Flow<User> = flow {
        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.toDomain(accessToken?: ""))
            }
        }

    }
}