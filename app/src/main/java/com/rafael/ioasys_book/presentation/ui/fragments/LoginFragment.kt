package com.rafael.ioasys_book.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rafael.ioasys_book.databinding.FragmentLoginBinding
import com.rafael.ioasys_book.presentation.viewmodel.LoginViewModel
import com.rafael.ioasys_book.util.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    //Boa prática para evitar memory leak
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentLoginBinding.inflate(
        inflater, container, false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        addObserver()
    }

    private fun setListener() {
        binding.enterButton.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    textFieldEditEmail.text.toString(),
                    textFieldEditPass.text.toString()
                )

                textFieldEditEmail.addTextChangedListener {
                    tvError.visibility = View.GONE
                }

                textFieldEditPass.addTextChangedListener {
                    tvError.visibility = View.GONE
                }
            }
        }
    }

    private fun addObserver() {
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment(accessToken = state.data)
                    )
                }
                is ViewState.Error -> {
                    binding.progressDialog.visibility = View.GONE
                    binding.tvError.visibility = View.VISIBLE
                }
                is ViewState.Loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }
                is ViewState.Neutral -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroy()
        loginViewModel.resetViewState()
        _binding = null
    }
}