package com.example.uniton4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _navigateType = MutableLiveData<NavigateScreenType>()
    val navigateType: LiveData<NavigateScreenType> = _navigateType

    fun setNavigateScreenType(type: NavigateScreenType) {
        _navigateType.value = type
    }
}
