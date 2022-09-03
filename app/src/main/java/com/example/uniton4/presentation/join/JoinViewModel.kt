package com.example.uniton4.presentation.join

import androidx.lifecycle.*
import com.example.uniton4.data.repository.SignUpRepository
import com.example.uniton4.data.request.SignUpRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
) : ViewModel() {
    val uiState = MutableLiveData<JoinUiState>()

    val nicknameLiveData = MutableLiveData<String>()
    val emailLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()

    val isActivatedSignUp: MediatorLiveData<Boolean> = MediatorLiveData()

    init {
        checkSignUpButton()
    }

    private fun checkSignUpButton() {
        isActivatedSignUp.addSource(nicknameLiveData) {
            isActivatedSignUp.value = isActivatedSignUpButton()
        }
        isActivatedSignUp.addSource(emailLiveData) {
            isActivatedSignUp.value = isActivatedSignUpButton()
        }
        isActivatedSignUp.addSource(passwordLiveData) {
            isActivatedSignUp.value = isActivatedSignUpButton()
        }
    }

    private fun isActivatedSignUpButton(): Boolean {
        if ((nicknameLiveData.value?.isNotEmpty() == true) and
            (emailLiveData.value?.isNotEmpty() == true) and
            (passwordLiveData.value?.isNotEmpty() == true)
        ) {
            return true
        }

        return false
    }

    fun signUp(
        email: String,
        nickname: String,
        password: String,
    ) {
        viewModelScope.launch {
            setState(JoinUiState.Loading)

            val signUpResult: Result<Boolean> = async {
                signUpRepository.signup(
                    SignUpRequest(
                        email = email,
                        nickname = nickname,
                        password = password
                    )
                )
            }.await()

            if (signUpResult.isSuccess) {
                setState(JoinUiState.Success)
            } else {
                setState(JoinUiState.Failed)
            }
        }
    }

    private fun setState(state: JoinUiState) {
        uiState.value = state
    }
}
