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
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBindingImpl
import com.example.uniton4.databinding.FragmentReceivedSadLetterBinding
import com.example.uniton4.databinding.FragmentReceivedSadLetterDialogBinding

class ReceivedSadLetterFragment private constructor() : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentReceivedSadLetterBinding
    private val parentViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceivedSadLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cheerupButton.setOnClickListener(this)
        binding.ignoreButton.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedSadLetterFragment()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.cheerupButton -> {
                parentViewModel.navigateByAdd(NavigateScreenType.RECEIVED_SAD_LETTER_DIALOG)

            }
            binding.ignoreButton -> {
                parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
            }
            else -> Unit
        }
    }
}