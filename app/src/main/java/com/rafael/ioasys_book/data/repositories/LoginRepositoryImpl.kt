package com.rafael.ioasys_book.data.repositories

import com.rafael.ioasys_book.data.datasource.LoginDatasource
import com.rafael.ioasys_book.domain.model.User
import com.rafael.ioasys_book.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDatasource: LoginDatasource
) : LoginRepository {
    override fun login(email: String, password: String): Flow<User> =
        loginDatasource.login(email, password)

}