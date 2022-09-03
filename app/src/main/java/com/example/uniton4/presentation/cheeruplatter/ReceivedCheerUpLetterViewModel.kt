package com.example.uniton4.presentation.cheeruplatter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.CheerRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceivedCheerUpLetterViewModel @Inject constructor(
    private val cheerRepository: CheerRepository
) : ViewModel() {
    val uiState = MutableLiveData<ReceivedCheerUpLetterUiState>()

    init {
        getCheers()
    }

    private fun getCheers() {
        viewModelScope.launch {
            setState(ReceivedCheerUpLetterUiState.Loading)

            val cheers = async { cheerRepository.selectCheers() }.await()
            if (cheers.isSuccess) {
                cheers.getOrNull()?.let {
                    setState(ReceivedCheerUpLetterUiState.Success(it))
                } ?: run {
                    setState(ReceivedCheerUpLetterUiState.Empty)
                }
            }
        }
    }

    private fun setState(state: ReceivedCheerUpLetterUiState) {
        uiState.value = state
    }
}
