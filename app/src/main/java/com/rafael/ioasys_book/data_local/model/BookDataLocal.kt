package com.rafael.ioasys_book.data_local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class BookDataLocal(
    @PrimaryKey
    val id: String? = null,
    val title: String? = null,
    val authors: String? = null,
    val pages: String? = null,
    val publisher: String? = null,
    val published: String? = null,
    val isbn10: String? = null,
    val isbn13: String? = null,
    val language: String? = null,
    val review: String? = null,
    val originName: String? = null,
    val imageUrl: String? = null
)
