package com.example.uniton4.presentation.join

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.databinding.FragmentJoinBinding

class JoinFragment private constructor() : Fragment(), View.OnClickListener {
    private val parentViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentJoinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJoinBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.joinBackButton.setOnClickListener(this)
        binding.joinButton.setOnClickListener(this)

    }

    companion object {
        @JvmStatic
        fun newInstance() = JoinFragment()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.joinBackButton -> {
                parentFragmentManager.popBackStack()
            }
            binding.joinButton -> {

            }
            else -> error("!!!!!")
        }
    }
}