package com.rafael.ioasys_book.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rafael.ioasys_book.R
import com.rafael.ioasys_book.databinding.BookItemBinding
import com.rafael.ioasys_book.domain.model.Book

class BookListAdapter(
    private val onBookClickListener: BookClickListener
) : ListAdapter<Book, BookListAdapter.BookListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem == newItem
        }
    }

    class BookListViewHolder(
        private val binding: BookItemBinding,
        private val onBookClickListener: BookClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.apply {
                tvBookTitle.text = book.title
                tvBookAuthor.text = book.authors
                tvPages.text = book.pages
                tvBookEditor.text = book.publisher
                tvBookDate.text = book.published
                imgBook.load(book.imageUrl) {
                    error(R.drawable.img_book_1)
                }

                root.setOnClickListener {
                    onBookClickListener.onBookClickListener(book)
                }


            }

        }

        companion object {
            fun create(
                parent: ViewGroup,
                onBookClickListener: BookClickListener
            ): BookListViewHolder {
                val binding = BookItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return BookListViewHolder(binding, onBookClickListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent, onBookClickListener)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}