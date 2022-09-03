package com.example.uniton4.presentation.login

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.LocalRepository
import com.example.uniton4.data.repository.LoginRepository
import com.example.uniton4.data.request.LoginRequest
import com.example.uniton4.domain.LoginEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    val uiState = MutableLiveData<LoginUiState>()

    val emailLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()

    val isActivatedLogin: MediatorLiveData<Boolean> = MediatorLiveData()

    init {
        checkLoginButton()
    }

    private fun checkLoginButton() {
        isActivatedLogin.addSource(emailLiveData) {
            isActivatedLogin.value = isActivatedLoginButton()
        }
        isActivatedLogin.addSource(passwordLiveData) {
            isActivatedLogin.value = isActivatedLoginButton()
        }
    }


    private fun isActivatedLoginButton(): Boolean {
        if ((emailLiveData.value?.isNotEmpty() == true) and
            (passwordLiveData.value?.isNotEmpty() == true)
        ) {
            return true
        }

        return false
    }

    fun login(
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            setState(LoginUiState.Loading)

            val loginResult: Result<LoginEntity> = async {
                loginRepository.login(
                    LoginRequest(
                        email = email,
                        password = password
                    )
                )
            }.await()

            if (loginResult.isSuccess) {
                setState(LoginUiState.Success)
            } else {
                setState(LoginUiState.Failed)
            }
        }
    }

    private fun setState(state: LoginUiState) {
        uiState.value = state
    }
}