package com.example.uniton4.presentation.writesadletter.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.uniton4.databinding.FragmentWriteSadLetterDialogBinding

class WriteSadLetterCompleteDialogFragment: DialogFragment() {
    private lateinit var binding: FragmentWriteSadLetterDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteSadLetterDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.okButton.setOnClickListener {
            dismiss()
        }
    }


    companion object {
        fun newInstance() = WriteSadLetterCompleteDialogFragment()
    }
}
