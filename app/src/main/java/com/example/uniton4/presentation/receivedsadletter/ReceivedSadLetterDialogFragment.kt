package com.example.uniton4.presentation.receivedsadletter

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentReceivedSadLetterDialogBinding
import com.example.uniton4.domain.RandomWorryEntity
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity
import com.example.uniton4.extensions.closeSelf
import com.example.uniton4.presentation.writecheer.WriteCheerFragment

class ReceivedSadLetterDialogFragment private constructor() : DialogFragment(),
    View.OnClickListener {
    private lateinit var binding: FragmentReceivedSadLetterDialogBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private var listener: ReceivedSadLetterListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentTheme)

        if (requireParentFragment() is ReceivedSadLetterListener) {
            listener = requireParentFragment() as? ReceivedSadLetterListener
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceivedSadLetterDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.container.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }
        binding.closeButton.setOnClickListener(this)
        binding.writeButton.setOnClickListener(this)

        val worryEntity = arguments?.getParcelable<RandomWorryEntity>(WORRY_ENTITY)
        binding.textView.text = worryEntity?.contents
    }

    companion object {
        private const val WORRY_ENTITY = "worry_entity"
        @JvmStatic
        fun newInstance(
            dto: RandomWorryEntity? = null
        ) = ReceivedSadLetterDialogFragment().apply {
            arguments = bundleOf(WORRY_ENTITY to dto)
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.closeButton -> {
                listener?.onClickClose()
                dismiss()
            }
            binding.writeButton -> {
                // TODO: save letter.
                WriteCheerFragment()
                    .show(childFragmentManager, WriteCheerFragment::class.java.name)
            }
        }
    }
}
