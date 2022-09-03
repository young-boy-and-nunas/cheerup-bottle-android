package com.example.uniton4.presentation.cheeruplatter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBinding
import com.example.uniton4.domain.RandomWorryEntity
import com.example.uniton4.presentation.cheeruplatter.adapter.ReceivedCheerUpLetterAdapter
import com.example.uniton4.presentation.cheeruplatter.adapter.ReceivedCheerUpLetterListener
import com.example.uniton4.presentation.receivedsadletter.dialog.ReceivedSadLetterDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceivedCheerUpLetterFragment : Fragment(), ReceivedCheerUpLetterListener {
    lateinit var binding: FragmentReceivedCheerupLetterBinding

    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: ReceivedCheerUpLetterViewModel by viewModels()

    private val adapter by lazy {
        ReceivedCheerUpLetterAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceivedCheerupLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initViews()
    }

    private fun observe() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            binding.uiState = state
            when (state) {
                is ReceivedCheerUpLetterUiState.Success -> {
                    adapter.submitList(state.list)
                    setCountText(state.list.size)
                }

                is ReceivedCheerUpLetterUiState.Empty -> {
                    binding.numberTextView.text = "0"
                }
            }
        }
    }

    private fun setCountText(size: Int) {
        binding.numberTextView.text = if (size > 99) {
            "99+"
        } else {
            size.toString()
        }
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        binding.addButton.setOnClickListener {
            parentViewModel.navigateByReplace(NavigateScreenType.WRITE_SED_LETTER)
        }
        binding.header.headerSettingButton.setOnClickListener {
            parentViewModel.navigateByAdd(NavigateScreenType.SETTING)
        }
    }

    override fun onClickLetter(dto: RandomWorryEntity) {
        ReceivedSadLetterDialogFragment
            .newInstance(dto)
            .show(childFragmentManager, ReceivedSadLetterDialogFragment::class.java.name)
    }

    companion object {
        fun newInstance() = ReceivedCheerUpLetterFragment()
    }

}
