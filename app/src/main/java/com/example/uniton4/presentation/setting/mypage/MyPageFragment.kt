package com.example.uniton4.presentation.setting.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentMyPageBinding
import com.example.uniton4.extensions.closeSelf
import com.example.uniton4.presentation.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment private constructor() : Fragment() {
    private lateinit var binding: FragmentMyPageBinding
    private val viewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPageBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mypageContainer.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }
        binding.backButton.setOnClickListener {
            closeSelf()
        }
        viewModel.getUser()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyPageFragment()
    }
}