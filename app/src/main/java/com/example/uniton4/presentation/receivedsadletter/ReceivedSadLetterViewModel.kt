package com.example.uniton4.presentation.receivedsadletter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.CheerRepository
import com.example.uniton4.data.repository.WorryRepository
import com.example.uniton4.domain.RandomWorryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceivedSadLetterViewModel @Inject constructor(
    private val worryRepository: WorryRepository,
) : ViewModel() {
    val uiState = MutableLiveData<ReceivedWorryUiState>()

    init {
        getRandomWorry()
    }

    private fun getRandomWorry() {
        setState(ReceivedWorryUiState.Loading)
        viewModelScope.launch {
            val loginResult: Result<RandomWorryEntity> = async {
                worryRepository.getRandomWorry()
            }.await()
            if (loginResult.isSuccess) {
                setState(ReceivedWorryUiState.Success(loginResult.getOrThrow()))
            } else {
                setState(ReceivedWorryUiState.Failed)
            }
        }
    }

    private fun setState(state: ReceivedWorryUiState) {
        uiState.value = state
    }
}
