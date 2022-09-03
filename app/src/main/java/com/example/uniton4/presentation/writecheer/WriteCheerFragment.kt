package com.example.uniton4.presentation.writecheer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentWriteCheerBinding
import com.example.uniton4.presentation.receivedsadletter.ReceivedSadLetterViewModel
import com.example.uniton4.presentation.receivedsadletter.ReceivedWorryUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteCheerFragment : DialogFragment(), View.OnClickListener {
    private lateinit var binding: FragmentWriteCheerBinding
    private val viewModel: WriteCheerViewModel by viewModels()
    private val parentViewModel: MainViewModel by activityViewModels()
    private var worryId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteCheerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        worryId = arguments?.getInt(WORRY_ID)
        initViews()
        observe()
    }

    private fun initViews() {
        binding.closeButton.setOnClickListener(this)
        binding.writeButton.setOnClickListener(this)
    }

    private fun observe() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is WriteCheerUiState.Success -> {
                    dismiss()
                    parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
                }

                is WriteCheerUiState.Failed -> {
                    Toast.makeText(requireContext(), "위로 작성에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.closeButton -> {
                dismiss()
                parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
            }
            binding.writeButton -> {
                worryId?.let {
                    viewModel.postCheers(binding.editText.text.toString(), it)
                }
            }
        }
    }


    companion object {
        private const val WORRY_ID = "worry_id"
        @JvmStatic
        fun newInstance(
            worryId: Int
        ) = WriteCheerFragment().apply {
            arguments = bundleOf(WORRY_ID to worryId)
        }
    }

}
