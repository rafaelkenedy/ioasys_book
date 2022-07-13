package com.rafael.ioasys_book.data_remote.model

import com.google.gson.annotations.SerializedName

data class BooksListResponse(
    @SerializedName("data")
    val data: List<BookResponse>
)
