package com.example.uniton4.presentation.cheeruplatter

import com.example.uniton4.domain.ReceivedCheerUpLetterEntity


sealed class ReceivedCheerUpLetterUiState {
    object Loading: ReceivedCheerUpLetterUiState()
    object Failed: ReceivedCheerUpLetterUiState()
    object Empty: ReceivedCheerUpLetterUiState()
    data class Success(val list: List<ReceivedCheerUpLetterEntity>): ReceivedCheerUpLetterUiState()
}
