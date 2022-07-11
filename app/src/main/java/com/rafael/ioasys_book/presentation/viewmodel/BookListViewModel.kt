package com.rafael.ioasys_book.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafael.ioasys_book.domain.exception.EmptyBookListException
import com.rafael.ioasys_book.domain.model.Book
import com.rafael.ioasys_book.util.ViewState
import com.rafael.ioasys_book.util.postError
import com.rafael.ioasys_book.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockListCount() }

    private fun getBooks(term: String): List<Book> {

        val input = term.trim()

        if (input.isEmpty()) {
            return bookDataList
        } else {
            return bookDataList.filter { book ->
                book.name.trim().contains(input, true)
            }
        }
    }

    fun search(term: String = "") {

        val input = term.trim()

        viewModelScope.launch {
            getBooks(input).let { books ->
                when {
                    books.isNotEmpty() -> {
                        _bookListViewState.postSuccess(books)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }
            }
        }

    }


}