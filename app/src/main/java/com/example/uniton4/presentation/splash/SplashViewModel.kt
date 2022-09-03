package com.example.uniton4.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val localRepository: LocalRepository
) : ViewModel() {
    val navigateToMain = MutableLiveData<Unit>()
    val navigateToLogin = MutableLiveData<Unit>()

    fun validateUser() {
        viewModelScope.launch {
            localRepository.getUserKey()
                .catch { navigateToLogin.value = Unit }
                .collectLatest {
                    if (it?.isNotEmpty() == true) {
                        navigateToMain.value = Unit
                    } else {
                        navigateToLogin.value = Unit
                    }
                }
        }
    }
}
