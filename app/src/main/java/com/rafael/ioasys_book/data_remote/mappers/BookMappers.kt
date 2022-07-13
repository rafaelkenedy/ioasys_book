package com.rafael.ioasys_book.data_remote.mappers

import com.rafael.ioasys_book.data_remote.model.BookResponse
import com.rafael.ioasys_book.domain.model.Book

fun List<BookResponse>.toDomain(): List<Book> {
    return this.map { book ->
        Book(
            id = book.id ?: "",
            title = book.title ?: "",
            authors = book.authors?.first() ?: "",
            pages = book.pages ?: "",
            publisher = book.publisher ?: "",
            originName = book.originName ?: "",
            published = book.published ?: "",
            isbn10 = book.isbn10 ?: "",
            isbn13 = book.isbn13 ?: "",
            language = book.language ?: "",
            review = book.review ?: "",
            imageUrl = book.imageUrl ?: ""
        )
    }
}