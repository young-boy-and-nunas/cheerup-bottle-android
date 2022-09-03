package com.example.uniton4.presentation.writesadletter.text

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.uniton4.databinding.FragmentWriteSadLetterTextBinding
import com.example.uniton4.presentation.writesadletter.WriteSadLetterViewModel

class WriteSadLetterTextFragment : Fragment() {
    lateinit var binding: FragmentWriteSadLetterTextBinding
    private val viewModel: WriteSadLetterTextViewModel by viewModels()
    private val parentViewModel: WriteSadLetterViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteSadLetterTextBinding.inflate(inflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.sadLetterEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(sequence: CharSequence?, p1: Int, p2: Int, p3: Int) =
                Unit

            override fun onTextChanged(sequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkTextLength(sequence)
                parentViewModel.saveTextWorry(sequence.toString())
            }

            override fun afterTextChanged(sequence: Editable?) = Unit
        })
    }

    private fun checkTextLength(sequence: CharSequence?) {
        if (sequence == null) return

        parentViewModel.handleCompleteButton(sequence.length)

        if (binding.counterText.text.length < MAX_TEXT_LENGTH) {
            binding.counterText.text = "${sequence?.length}/${MAX_TEXT_LENGTH}"
        }
    }

    companion object {
        const val MAX_TEXT_LENGTH = 2000
        fun newInstance() = WriteSadLetterTextFragment()
    }
}
