package com.rafael.ioasys_book.data.datasource.remote

import com.rafael.ioasys_book.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDatasource {

    fun login(email: String, password: String): Flow<User>
}