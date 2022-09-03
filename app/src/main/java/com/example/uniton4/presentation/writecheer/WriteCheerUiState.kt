package com.example.uniton4.presentation.writecheer

sealed class WriteCheerUiState {
    object Loading: WriteCheerUiState()
    object Failed: WriteCheerUiState()
    object Success: WriteCheerUiState()
}
