package com.rafael.ioasys_book.data_remote.datasource

import com.rafael.ioasys_book.data.datasource.LoginDatasource
import com.rafael.ioasys_book.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDatasourceImpl : LoginDatasource {
    override fun login(email: String, password: String): Flow<User> = flow {
        delay(2_000)
        emit(
            User(
                name = "Rafael",
                birthDate = "0/01/1990",
                gender = "Male",
                accessToken = "fadsIiopiojFGHHH"
            )
        )
    }
}