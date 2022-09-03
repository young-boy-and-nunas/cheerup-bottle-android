package com.example.uniton4.presentation.setting.removeaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentRemoveAccountDialogBinding
import com.example.uniton4.extensions.closeSelf
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_remove_account_dialog.view.*

@AndroidEntryPoint
class RemoveAccountDialogFragment private constructor() : DialogFragment(), View.OnClickListener {
    private lateinit var binding: FragmentRemoveAccountDialogBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private val viewModel: RemoveAccountViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRemoveAccountDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.panel.cancel_button.setOnClickListener(this)
        binding.panel.confirm_button.setOnClickListener(this)
        observe()
    }

    private fun observe() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) { isSucceed ->
            if (isSucceed) {
                parentViewModel.navigateByReplace(NavigateScreenType.LOGIN)
                dismiss()
            } else {
                Toast.makeText(context, "계정 삭제 실패!!!", Toast.LENGTH_LONG).show()
                dismiss()
            }
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.panel.cancel_button -> {
                closeSelf()
            }
            binding.panel.confirm_button -> {
                viewModel.withThrowUser()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RemoveAccountDialogFragment()
    }
}