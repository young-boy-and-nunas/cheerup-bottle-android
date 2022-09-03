package com.example.uniton4.presentation.writesadletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WriteSadLetterFragment: Fragment() {
    lateinit var binding: FragmentWriteSadLetterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteSadLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
    }

    companion object {
        fun newInstance() = WriteSadLetterFragment()
    }
}
