package com.rafael.ioasys_book.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rafael.ioasys_book.presentation.adapter.BookClickListener
import com.rafael.ioasys_book.presentation.adapter.BookListAdapter
import com.rafael.ioasys_book.databinding.FragmentBookListBinding
import com.rafael.ioasys_book.domain.model.Book

class BookListFragment : Fragment(), BookClickListener{

    private val args: BookListFragmentArgs by navArgs()
    private lateinit var bookListAdapter: BookListAdapter
    private var _binding: FragmentBookListBinding? = null
    private val binding: FragmentBookListBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookListBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    //Equivalente À onCreate numa View
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookListData()
        args.itemCount
    }

    override fun onDestroyView() {
        super.onDestroy()
        _binding = null
    }

    private fun setBookListData() {
        bookListAdapter = BookListAdapter(this)
        binding.rvBooks.adapter = bookListAdapter
        bookListAdapter.submitList(
            Book.getMockListCount(args.itemCount)
        )
    }

    override fun onBookClickListener(book: Book) {
        BookDetailsFragment.newInstance(book).show(childFragmentManager, this.tag)
    }
}