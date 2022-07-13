package com.rafael.ioasys_book.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafael.ioasys_book.domain.model.Book
import com.rafael.ioasys_book.domain.repositories.BooksRepository
import com.rafael.ioasys_book.util.ViewState
import com.rafael.ioasys_book.util.postError
import com.rafael.ioasys_book.util.postLoading
import com.rafael.ioasys_book.util.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    //private val bookDataList: List<Book> by lazy { Book.getMockListCount() }

    fun search(input: String = "", accessToken: String) {

        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(accessToken, input).collect { books ->
                    if (books.isNotEmpty()) {
                        _bookListViewState.postSuccess(books)
                    } else {
                        _bookListViewState.postError(Exception())
                    }
                }

            } catch (err: Exception) {
                _bookListViewState.postError(Exception(err))
            }
        }
    }

}