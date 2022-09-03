package com.example.uniton4.presentation.receivedsadletter

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.data.request.ContentUriRequestBody
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBindingImpl
import com.example.uniton4.databinding.FragmentReceivedSadLetterBinding
import com.example.uniton4.databinding.FragmentReceivedSadLetterDialogBinding

class ReceivedSadLetterFragment private constructor() : Fragment(),
    View.OnClickListener,
    ReceivedSadLetterListener {
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
        binding.header.headerSettingButton.setOnClickListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedSadLetterFragment()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.cheerupButton -> {
                ReceivedSadLetterDialogFragment
                    .newInstance()
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
}
