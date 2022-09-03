package com.example.uniton4.presentation.cheeruplatter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceivedCheerUpLetterFragment: Fragment() {

    lateinit var binding: FragmentReceivedCheerupLetterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReceivedCheerupLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
