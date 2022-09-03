package com.example.uniton4.presentation.login

sealed class LoginUiState {
    object Loading: LoginUiState()
    object Failed: LoginUiState()
    object Success: LoginUiState()
}
