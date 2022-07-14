package com.rafael.ioasys_book.data_local.mappers

import com.rafael.ioasys_book.data_local.model.BookDataLocal
import com.rafael.ioasys_book.domain.model.Book

fun Book.toDao(): BookDataLocal = BookDataLocal(
    id = this.id,
    title = this.title,
    authors = this.authors,
    pages = this.pages,
    publisher = this.publisher,
    originName = this.originName,
    published = this.published,
    isbn10 = this.isbn10,
    isbn13 = this.isbn13,
    language = this.language,
    review = this.review,
    imageUrl = this.imageUrl
)

fun BookDataLocal.toDomain(): Book = Book(
    id = this.id,
    title = this.title ?: "",
    authors = this.authors ?: "",
    pages = this.pages ?: "",
    publisher = this.publisher ?: "",
    originName = this.originName ?: "",
    published = this.published ?: "",
    isbn10 = this.isbn10 ?: "",
    isbn13 = this.isbn13 ?: "",
    language = this.language ?: "",
    review = this.review ?: "",
    imageUrl = this.imageUrl ?: ""

)