package com.example.uniton4.presentation.receivedsadletter

import com.example.uniton4.domain.RandomWorryEntity

sealed class ReceivedWorryUiState {
    object Loading: ReceivedWorryUiState()
    object Failed: ReceivedWorryUiState()
    data class Success(val entity: RandomWorryEntity): ReceivedWorryUiState()
}
