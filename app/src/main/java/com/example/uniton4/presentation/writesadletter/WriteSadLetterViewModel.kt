package com.example.uniton4.presentation.writesadletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentWriteSadLetterBinding
import com.example.uniton4.databinding.FragmentWriteSadLetterImageBinding
import com.example.uniton4.presentation.writesadletter.audio.WriteSadLetterAudioFragment
import com.example.uniton4.presentation.writesadletter.image.WriteSadLetterImageFragment
import com.example.uniton4.presentation.writesadletter.text.WriteSadLetterTextFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

class WriteSadLetterViewModel: ViewModel() {
    private val _isActiveCompleteButton = MutableLiveData<Boolean>(false)
    val isActiveCompleteButton: LiveData<Boolean> = _isActiveCompleteButton

    private val _circleType = MutableLiveData<WriteSadLetterCircleType>(WriteSadLetterCircleType.TEXT)
    val circleType: LiveData<WriteSadLetterCircleType> = _circleType

    fun handleCompleteButton(length: Int) {
        _isActiveCompleteButton.value = length >= MIN_TEXT_LENGTH
    }

    fun setCircleType(type: WriteSadLetterCircleType) {
        _circleType.value = type
    }

    fun activeCompleteButton() {
        _isActiveCompleteButton.value = true
    }

    fun inActiveCompleteButton() {
        _isActiveCompleteButton.value = false
    }

    companion object {
        const val MIN_TEXT_LENGTH = 1
    }
}
