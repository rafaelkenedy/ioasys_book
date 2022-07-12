package com.rafael.ioasys_book.domain.repositories

import com.rafael.ioasys_book.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    //Inversão de dependência
    fun login(email: String, password: String): Flow<User>

}