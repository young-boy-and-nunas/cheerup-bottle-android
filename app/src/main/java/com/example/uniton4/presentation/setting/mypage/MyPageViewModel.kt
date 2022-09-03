package com.example.uniton4.presentation.setting.mypage

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
class MyPageViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val emailLiveData = MutableLiveData<String>()
    val nicknameLiveData = MutableLiveData<String>()
    fun getUser() {
        viewModelScope.launch {
            userRepository.getUser()

            val userResult: Result<UserEntity> = async {
                userRepository.getUser()
            }.await()

            if (userResult.isSuccess) {
                userResult.getOrNull()?.let {
                    Log.d("coqkf",it.toString())
                    emailLiveData.postValue(it.email)
                    nicknameLiveData.postValue(it.nickname)
                }
            } else {
                // TODO
            }
        }
    }
}