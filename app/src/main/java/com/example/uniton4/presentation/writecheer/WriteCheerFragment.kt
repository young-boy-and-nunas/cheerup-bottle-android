package com.example.uniton4.presentation.writecheer

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.uniton4.MainViewModel
import com.example.uniton4.NavigateScreenType
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentMyPageBinding
import com.example.uniton4.databinding.FragmentWriteCheerBinding
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import com.example.uniton4.extensions.closeSelf

class WriteCheerFragment : DialogFragment(), View.OnClickListener {
    private lateinit var binding: FragmentWriteCheerBinding
    private val parentViewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteCheerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFullScreen()
        binding.container.setOnTouchListener { _, _ ->
            return@setOnTouchListener true
        }
        binding.closeButton.setOnClickListener(this)
        binding.writeButton.setOnClickListener(this)
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
            binding.closeButton -> {
                Log.d("coqkf","close")
//                closeSelf()
                parentViewModel.navigateByReplace(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
            }
            binding.writeButton -> {
                // TODO 작성완료
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WriteCheerFragment()
    }


}