package com.example.uniton4.presentation.setting.removeaccount

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.fragment.app.DialogFragment
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentRemoveAccountDialogBinding
import com.example.uniton4.extensions.closeSelf
import kotlinx.android.synthetic.main.fragment_remove_account_dialog.view.*

class RemoveAccountDialogFragment private constructor() : DialogFragment(), View.OnClickListener {
    private lateinit var binding: FragmentRemoveAccountDialogBinding

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
        setFullScreen()
        binding.container.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }
        binding.panel.cancel_button.setOnClickListener(this)
        binding.panel.confirm_button.setOnClickListener(this)
    }

    private fun setFullScreen() {
        val window = dialog?.window ?: return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.panel.cancel_button -> {
                closeSelf()
            }
            binding.panel.confirm_button -> {
                closeSelf()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RemoveAccountDialogFragment()
    }
}