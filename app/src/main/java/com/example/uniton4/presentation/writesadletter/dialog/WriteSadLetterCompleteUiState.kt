package com.example.uniton4.presentation.writesadletter.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.WorryRepository
import com.example.uniton4.domain.RandomWorryEntity
import com.example.uniton4.presentation.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class WriteSadLetterCompleteUiState {
    object Loading: WriteSadLetterCompleteUiState()
    object Failed: WriteSadLetterCompleteUiState()
    object Success: WriteSadLetterCompleteUiState()
}
