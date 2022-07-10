package com.rafael.ioasys_book.adapter

import com.rafael.ioasys_book.model.Book

interface BookClickListener {
    fun onBookClickListener(book: Book)
}