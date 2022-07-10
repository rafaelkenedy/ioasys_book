package com.rafael.ioasys_book.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rafael.ioasys_book.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //Boa prática para evitar memory leak
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() {
        binding.enterButton.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToBookListFragment(5)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroy()
        _binding = null
    }
}