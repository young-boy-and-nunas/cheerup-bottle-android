package com.example.uniton4.presentation.writesadletter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.WorryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
sealed class WriteSadLetterUiState {
    object Loading: WriteSadLetterUiState()
    object Success: WriteSadLetterUiState()
    object Failed: WriteSadLetterUiState()
}
