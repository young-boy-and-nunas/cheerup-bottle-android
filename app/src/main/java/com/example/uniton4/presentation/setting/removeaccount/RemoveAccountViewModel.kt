package com.example.uniton4.presentation.setting.removeaccount

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uniton4.data.repository.UserRepository
import com.example.uniton4.domain.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RemoveAccountViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val resultLiveData = MutableLiveData<Boolean>()

    fun withThrowUser() {
        viewModelScope.launch {
            val userResult: Result<Boolean> = async {
                userRepository.withThrowUser()
            }.await()

            resultLiveData.value = userResult.isSuccess
        }
    }
}