package com.example.uniton4.presentation.receivedsadletter

sealed class ReceivedWorryUiState {
    object Loading: ReceivedWorryUiState()
    object Failed: ReceivedWorryUiState()
    object Success: ReceivedWorryUiState()
}
