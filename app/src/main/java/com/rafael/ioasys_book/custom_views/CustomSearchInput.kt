package com.rafael.ioasys_book.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText
import com.rafael.ioasys_book.R

class CustomSearchInput @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0

) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val view = LayoutInflater.from(context).inflate(R.layout.custom_search_input, this, true)

    private val input: TextInputEditText by lazy {
        view.findViewById(R.id.etSearch)
    }

}

