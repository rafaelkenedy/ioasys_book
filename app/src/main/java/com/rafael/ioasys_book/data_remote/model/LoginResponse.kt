package com.rafael.ioasys_book.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("birthdate")
    val birthDate: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String
)
