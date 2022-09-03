package com.example.uniton4.presentation.writesadletter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.WorryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
class WriteSadLetterViewModel @Inject constructor(
    private val worryRepository: WorryRepository
): ViewModel() {
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

    fun saveTextWorry(text: String) {
        viewModelScope.launch {
            val createWorry = worryRepository.createWorry(text)
            if (createWorry.isSuccess) {

            } else {

            }
        }
    }

    companion object {
        const val MIN_TEXT_LENGTH = 1
    }
}
