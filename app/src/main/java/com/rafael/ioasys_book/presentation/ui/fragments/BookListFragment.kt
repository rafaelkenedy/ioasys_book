package com.rafael.ioasys_book.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rafael.ioasys_book.databinding.FragmentBookListBinding
import com.rafael.ioasys_book.domain.exception.EmptyBookListException
import com.rafael.ioasys_book.domain.model.Book
import com.rafael.ioasys_book.presentation.adapter.BookClickListener
import com.rafael.ioasys_book.presentation.adapter.BookListAdapter
import com.rafael.ioasys_book.presentation.viewmodel.BookListViewModel
import com.rafael.ioasys_book.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment(), BookClickListener {

    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!
    private val bookListViewModel: BookListViewModel by viewModel()

    private val args: BookListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    //Equivalente À onCreate numa View
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureListeners()
        setBookListData()
        addObserver()
    }

    private fun configureListeners() {
        binding.edSearch.textChangeListener = { input ->
            bookListViewModel.search(input, args.accessToken)
        }

    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        bookListViewModel.search(accessToken = args.accessToken)

    }

    override fun onBookClickListener(book: Book) {
        BookDetailsFragment.newInstance(book).show(childFragmentManager, this.tag)
    }

    private fun addObserver() {
        bookListViewModel.bookListViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    showEmptyListError(false)
                    bookListAdapter.submitList(
                        state.data
                    )
                }
                is ViewState.Error -> {
                    when (state.throwable) {
                        is EmptyBookListException -> {
                            bookListAdapter.submitList(listOf())
                            showEmptyListError(true)
                        }
                        else -> Unit
                    }

                }
                else -> Unit
            }

        }

    }

    private fun showEmptyListError(hasError: Boolean) {
        binding.tvEmptyList.visibility = if (hasError) View.VISIBLE else View.GONE

    }

    override fun onDestroyView() {
        super.onDestroy()
        _binding = null
    }
}