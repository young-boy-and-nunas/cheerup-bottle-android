package com.example.uniton4.presentation.receivedsadletter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentReceivedSadLetterBinding
import com.example.uniton4.presentation.receivedsadletter.dialog.ReceivedSadLetterDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceivedSadLetterFragment private constructor() : Fragment(),
    View.OnClickListener,
    ReceivedSadLetterListener {
    private lateinit var binding: FragmentReceivedSadLetterBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: ReceivedSadLetterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceivedSadLetterBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        binding.cheerupButton.setOnClickListener(this)
        binding.ignoreButton.setOnClickListener(this)
        binding.header.headerSettingButton.setOnClickListener(this)
    }

    private fun observe() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ReceivedWorryUiState.Success -> {
                    binding.entity = state.entity
                }
            }
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.cheerupButton -> {
                ReceivedSadLetterDialogFragment
                    .newInstance(binding.entity)
                    .show(childFragmentManager, ReceivedSadLetterDialogFragment::class.java.name)
            }
            binding.ignoreButton -> {
                parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
            }
            binding.header.headerSettingButton -> {
                parentViewModel.navigateByAdd(NavigateScreenType.SETTING)
            }
            else -> Unit
        }
    }

    override fun onClickClose() {
        parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedSadLetterFragment()
    }


}
