package com.example.uniton4.presentation.receivedsadletter.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentReceivedSadLetterDialogBinding
import com.example.uniton4.domain.RandomWorryEntity
import com.example.uniton4.presentation.receivedsadletter.ReceivedSadLetterListener
import com.example.uniton4.presentation.writecheer.WriteCheerFragment

class ReceivedSadLetterDialogFragment private constructor() : DialogFragment(),
    View.OnClickListener {
    private lateinit var binding: FragmentReceivedSadLetterDialogBinding
    private val parentViewModel: MainViewModel by activityViewModels()

    private var listener: ReceivedSadLetterListener? = null
    private var worryEntity : RandomWorryEntity? = null

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

        worryEntity = arguments?.getParcelable<RandomWorryEntity>(WORRY_ENTITY)
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
                worryEntity?.worrySeq?.let { id ->
                    WriteCheerFragment
                        .newInstance(id)
                        .show(childFragmentManager, WriteCheerFragment::class.java.name)
                }
            }
        }
    }
}
