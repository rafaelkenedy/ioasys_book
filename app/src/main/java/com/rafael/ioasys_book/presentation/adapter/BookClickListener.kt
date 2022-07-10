package com.rafael.ioasys_book.presentation.adapter

import com.rafael.ioasys_book.domain.model.Book

interface BookClickListener {
    fun onBookClickListener(book: Book)
}