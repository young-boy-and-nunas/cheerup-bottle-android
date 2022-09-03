package com.example.uniton4.presentation.writesadletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import com.example.uniton4.databinding.FragmentWriteSadLetterImageBinding
import com.example.uniton4.presentation.writesadletter.audio.WriteSadLetterAudioFragment
import com.example.uniton4.presentation.writesadletter.image.WriteSadLetterImageFragment
import com.example.uniton4.presentation.writesadletter.text.WriteSadLetterTextFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class WriteSadLetterFragment: Fragment() {
    private lateinit var binding: FragmentWriteSadLetterBinding

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
        addFragment()
    }

    private fun addFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.sadLetterFragmentContainer, WriteSadLetterTextFragment.newInstance())
            .commit()
    }

    private fun initViews() {
        binding.textCircle.setOnClickListener {
            replaceFragment(WriteSadLetterTextFragment.newInstance())
        }

        binding.imageCircle.setOnClickListener {
            replaceFragment(WriteSadLetterImageFragment.newInstance())
        }

        binding.audioCircle.setOnClickListener {
            replaceFragment(WriteSadLetterAudioFragment.newInstance())
        }
    }

    private fun replaceFragment(classType: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.sadLetterFragmentContainer, classType)
            .commit()
    }

    companion object {
        fun newInstance() = WriteSadLetterFragment()
    }
}
