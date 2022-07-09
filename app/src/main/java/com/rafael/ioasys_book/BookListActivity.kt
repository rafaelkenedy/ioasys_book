package com.rafael.ioasys_book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.rafael.ioasys_book.adapter.BookListAdapter
import com.rafael.ioasys_book.model.Book

class BookListActivity : AppCompatActivity() {

    private lateinit var bookListAdapter: BookListAdapter
    private val rvBooks: RecyclerView by lazy {
        findViewById(R.id.rvBooks)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setBookListData()
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter()
        rvBooks.adapter = bookListAdapter

        bookListAdapter.submitList(Book.getBookList())

    }
}