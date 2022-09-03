package com.example.uniton4.presentation.writesadletter.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentWriteSadLetterDialogBinding

class WriteSadLetterCompleteDialogFragment: DialogFragment() {
    private lateinit var binding: FragmentWriteSadLetterDialogBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: WriteSadLetterCompleteViewModel by viewModels()

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
          //  viewModel.postTextWorry()
            parentViewModel.navigateByReplace(NavigateScreenType.WRITE_SED_LETTER)
            Toast.makeText(requireContext(), "작성이 완료되었습니다.", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }


    companion object {
        fun newInstance() = WriteSadLetterCompleteDialogFragment()
    }
}
