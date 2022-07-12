package com.rafael.ioasys_book.data_remote.mappers

import com.rafael.ioasys_book.data_remote.model.LoginResponse
import com.rafael.ioasys_book.domain.model.User

fun LoginResponse.toDomain(accessToken: String) = User(
    name = this.name,
    birthDate = this.birthDate,
    gender = this.gender,
    id = this.id,
    accessToken = accessToken
)