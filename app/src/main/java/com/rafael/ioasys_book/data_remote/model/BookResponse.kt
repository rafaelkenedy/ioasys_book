package com.rafael.ioasys_book.data_remote.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("authors")
    val authors: List<String>?,
    @SerializedName("pageCount")
    val pages: String?,
    @SerializedName("publisher")
    val publisher: String?,
    @SerializedName("published")
    val published: String?,
    @SerializedName("isbn10")
    val isbn10: String?,
    @SerializedName("isbn13")
    val isbn13: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("description")
    val review: String?,
    @SerializedName("originName")
    val originName: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?
)
