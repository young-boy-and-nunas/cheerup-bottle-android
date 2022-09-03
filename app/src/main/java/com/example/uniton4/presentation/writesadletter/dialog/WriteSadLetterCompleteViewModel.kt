package com.example.uniton4.presentation.writesadletter.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.WorryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteSadLetterCompleteViewModel @Inject constructor(
    private val worryRepository: WorryRepository
) : ViewModel() {
    val uiState = MutableLiveData<WriteSadLetterCompleteUiState>()

    fun postTextWorry(text: String) {
        viewModelScope.launch {
            setState(WriteSadLetterCompleteUiState.Loading)
            if (worryRepository.createWorry(text).isSuccess) {
                setState(WriteSadLetterCompleteUiState.Success)
            } else {
                setState(WriteSadLetterCompleteUiState.Failed)
            }
        }
    }

    private fun setState(state: WriteSadLetterCompleteUiState) {
        uiState.value = state
    }
}
