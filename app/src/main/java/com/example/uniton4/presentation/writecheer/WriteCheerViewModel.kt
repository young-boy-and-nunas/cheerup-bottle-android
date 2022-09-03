package com.example.uniton4.presentation.writecheer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.CheerRepository
import com.example.uniton4.presentation.receivedsadletter.ReceivedWorryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteCheerViewModel @Inject constructor(
    private val cheerRepository: CheerRepository
) : ViewModel() {
    val uiState = MutableLiveData<WriteCheerUiState>()

    fun postCheers(
        cheers: String,
        worryId: Int,
    ) {
        viewModelScope.launch {
            val result = cheerRepository.makeCheer(cheers, worryId)
            if (result.isSuccess) {
                setState(WriteCheerUiState.Success)
            } else {
                setState(WriteCheerUiState.Failed)
            }
        }
    }

    private fun setState(state: WriteCheerUiState) {
        uiState.value = state
    }

}
