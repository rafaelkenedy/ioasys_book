package com.rafael.ioasys_book.presentation.ui.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rafael.ioasys_book.R
import com.rafael.ioasys_book.databinding.FragmentBookDetailsBinding
import com.rafael.ioasys_book.domain.model.Book


class BookDetailsFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBookDetailsBinding? = null
    private val binding: FragmentBookDetailsBinding get() = _binding!!
    private var book: Book? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookDetailsBinding.inflate(inflater, container, false)
        .apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListener()
        setupBookDetailToTop()
    }

    private fun setupBookDetailToTop() {
        (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    private fun setListener() {
        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    private fun setupView() {
        binding.apply {

            tvBookName.text = book?.name
            tvBookAuthor.text = book?.author
            tvBookPages.text = book?.pages
            tvBookEditor.text = book?.pages
            tvBookDate.text = book?.date
            tvBookLanguage.text = book?.language
            tvBookOriginName.text = book?.originName
            tvBookISBN10.text = book?.isbn10
            tvBookISBN13.text = book?.isbn13

            val spannableString = SpannableString("   ${book?.review}")
            val imageSpan = ImageSpan(requireContext(), R.drawable.ic_quotes)
            spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)

            tvReview.text = spannableString
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(book: Book? = null): BookDetailsFragment {
            return BookDetailsFragment().apply {
                this.book = book
            }
        }
    }

}