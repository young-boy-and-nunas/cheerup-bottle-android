package com.example.uniton4.presentation.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), View.OnClickListener {
    private val parentViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginJoinButton.setOnClickListener(this)

    }

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.loginJoinButton -> {
                parentViewModel.navigateByAdd(NavigateScreenType.JOIN)
            }
            else -> Unit
        }
    }
}
