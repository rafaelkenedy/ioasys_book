package com.rafael.ioasys_book.data.repositories

import com.rafael.ioasys_book.data.datasource.local.LoginLocalDatasource
import com.rafael.ioasys_book.data.datasource.remote.LoginRemoteDatasource
import com.rafael.ioasys_book.domain.model.User
import com.rafael.ioasys_book.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginRemoteDatasource: LoginRemoteDatasource,
    private val loginLocalDatasource: LoginLocalDatasource
) : LoginRepository {
    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDatasource.login(email, password).collect { userData ->
            loginLocalDatasource.saveAccessToken(userData.accessToken)

            emit(userData)
        }
    }


}