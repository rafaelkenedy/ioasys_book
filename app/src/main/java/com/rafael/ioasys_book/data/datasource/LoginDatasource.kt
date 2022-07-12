package com.rafael.ioasys_book.data.datasource

import com.rafael.ioasys_book.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {

    fun login(email: String, password: String): Flow<User>
}