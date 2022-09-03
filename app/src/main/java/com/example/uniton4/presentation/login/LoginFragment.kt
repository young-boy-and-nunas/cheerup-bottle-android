package com.example.uniton4.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(), View.OnClickListener {
    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginJoinButton.setOnClickListener(this)
        binding.loginButton.setOnClickListener(this)

        observe()
    }

    private fun observe() {
        viewModel.isActivatedLogin.observe(viewLifecycleOwner) {
            binding.loginButton.isActivated = it
        }

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            binding.uiState = state
            when (state) {
                LoginUiState.Failed -> {
                    Toast.makeText(requireContext(), "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
                LoginUiState.Success -> {
                    parentViewModel.navigateByReplace(NavigateScreenType.LOGIN)
                    parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_SAD_LETTER)
                }
                else -> Unit
            }
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.loginJoinButton -> {
                parentViewModel.navigateByAdd(NavigateScreenType.JOIN)
            }
            binding.loginButton -> {
                viewModel.login(
                    binding.loginIdEdittext.text.toString(),
                    binding.loginPasswordEdittext.text.toString(),
                )
            }
            else -> Unit
        }
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
