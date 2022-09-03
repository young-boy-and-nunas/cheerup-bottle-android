package com.example.uniton4.presentation.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentSettingBinding
import com.example.uniton4.extensions.closeSelf

class SettingFragment private constructor() : Fragment(), View.OnClickListener {
    private val parentViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener(this)
        binding.mypage.setOnClickListener(this)
        binding.removeAccount.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.backButton -> {
                closeSelf()
            }
            binding.mypage -> {
                parentViewModel.navigateByAdd(NavigateScreenType.MYPAGE)
            }
            binding.removeAccount -> {
                parentViewModel.navigateByAdd(NavigateScreenType.REMOVE_ACCOUNT)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }

}