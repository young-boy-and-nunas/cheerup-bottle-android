package com.example.uniton4.presentation.join

sealed class JoinUiState {
    object Loading: JoinUiState()
    object Failed: JoinUiState()
    object Success: JoinUiState()
}
