package com.rafael.ioasys_book.domain.model

data class Book(
    val id: String,
    val title: String,
    val authors: String,
    val pages: String,
    val publisher: String,
    val published: String,
    val isbn10: String,
    val isbn13: String,
    val language: String,
    val review: String,
    val originName: String,
    val imageUrl: String
)