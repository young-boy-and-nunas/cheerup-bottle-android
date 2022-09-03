package com.example.uniton4.presentation.writesadletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import com.example.uniton4.databinding.FragmentWriteSadLetterImageBinding
import com.example.uniton4.presentation.writesadletter.audio.WriteSadLetterAudioFragment
import com.example.uniton4.presentation.writesadletter.dialog.WriteSadLetterCompleteDialogFragment
import com.example.uniton4.presentation.writesadletter.image.WriteSadLetterImageFragment
import com.example.uniton4.presentation.writesadletter.text.WriteSadLetterTextFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class WriteSadLetterFragment: Fragment() {
    private lateinit var binding: FragmentWriteSadLetterBinding
    private val viewModel: WriteSadLetterViewModel by viewModels()
    private val parentViewModel: MainViewModel by activityViewModels()

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
        observe()
        addFragment()
    }

    private fun addFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.sadLetterFragmentContainer, WriteSadLetterTextFragment.newInstance())
            .commit()
    }

    private fun initViews() {
        viewModel.setCircleType(WriteSadLetterCircleType.TEXT)

        binding.textCircle.setOnClickListener {
            viewModel.setCircleType(WriteSadLetterCircleType.TEXT)
            viewModel.inActiveCompleteButton()
            replaceFragment(WriteSadLetterTextFragment.newInstance())
        }

        binding.imageCircle.setOnClickListener {
            viewModel.setCircleType(WriteSadLetterCircleType.IMAGE)
            viewModel.inActiveCompleteButton()
            replaceFragment(WriteSadLetterImageFragment.newInstance())
        }

        binding.audioCircle.setOnClickListener {
            viewModel.setCircleType(WriteSadLetterCircleType.AUDIO)
            viewModel.inActiveCompleteButton()
            replaceFragment(WriteSadLetterAudioFragment.newInstance())
        }

        binding.completeButton.setOnClickListener {
            WriteSadLetterCompleteDialogFragment
                .newInstance()
                .show(childFragmentManager, WriteSadLetterCompleteDialogFragment::class.java.name)
        }

        binding.backButton.setOnClickListener {
            parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
        }
    }

    private fun observe() {
        viewModel.isActiveCompleteButton.observe(viewLifecycleOwner) { isActive ->
            binding.isActive = isActive
        }

        viewModel.circleType.observe(viewLifecycleOwner) { type ->
            binding.circleType = type
            when (type) {
                WriteSadLetterCircleType.TEXT -> {
                    binding.textCircle.isSelected = true
                    binding.audioCircle.isSelected = false
                    binding.imageCircle.isSelected = false
                }
                WriteSadLetterCircleType.AUDIO -> {
                    binding.textCircle.isSelected = false
                    binding.audioCircle.isSelected = true
                    binding.imageCircle.isSelected = false
                }
                WriteSadLetterCircleType.IMAGE -> {
                    binding.textCircle.isSelected = false
                    binding.audioCircle.isSelected = false
                    binding.imageCircle.isSelected = true
                }
            }
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
