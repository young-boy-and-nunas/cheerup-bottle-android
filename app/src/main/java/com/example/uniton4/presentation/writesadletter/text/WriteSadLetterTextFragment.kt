package com.example.uniton4.presentation.writesadletter.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import com.example.uniton4.databinding.FragmentWriteSadLetterTextBinding

class WriteSadLetterTextFragment: Fragment() {
    lateinit var binding: FragmentWriteSadLetterTextBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteSadLetterTextBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = WriteSadLetterTextFragment()
    }
}
