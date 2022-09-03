package com.example.uniton4.presentation.setting.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentMyPageBinding
import com.example.uniton4.extensions.closeSelf

class MyPageFragment private constructor() : Fragment() {
    private lateinit var binding: FragmentMyPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPageBinding.inflate(inflater)
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
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyPageFragment()
    }
}