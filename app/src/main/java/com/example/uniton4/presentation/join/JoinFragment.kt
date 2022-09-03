package com.example.uniton4.presentation.join

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentJoinBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JoinFragment private constructor() : Fragment(), View.OnClickListener {
    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: JoinViewModel by viewModels()
    private lateinit var binding: FragmentJoinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJoinBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.joinBackButton.setOnClickListener(this)
        binding.joinButton.setOnClickListener(this)

        initViews()
        observe()
    }

    private fun initViews() {
        binding.joinButton.setOnClickListener {
            viewModel.signUp(
                binding.joinEmailEdittext.text.toString(),
                binding.joinNicknameEdittext.text.toString(),
                binding.joinPasswordEdittext.text.toString()
            )
        }
    }

    private fun observe() {
        viewModel.isActivatedSignUp.observe(viewLifecycleOwner) {
            binding.joinButton.isActivated = it
        }

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            binding.uiState = state
            when (state) {
                JoinUiState.Failed -> {
                    Toast.makeText(requireContext(), "회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
                JoinUiState.Success -> {
                    parentViewModel.navigateByReplace(NavigateScreenType.LOGIN)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = JoinFragment()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.joinBackButton -> {
                parentFragmentManager.popBackStack()
            }
            binding.joinButton -> {

            }
            else -> error("!!!!!")
        }
    }
}
