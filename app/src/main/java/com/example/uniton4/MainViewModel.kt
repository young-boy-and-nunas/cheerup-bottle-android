package com.example.uniton4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _navigateByReplace = MutableLiveData<NavigateScreenType>()
    private val _navigateByAdd = MutableLiveData<NavigateScreenType>()
    val navigateByReplace: LiveData<NavigateScreenType> = _navigateByReplace
    val navigateByAdd: LiveData<NavigateScreenType> = _navigateByAdd

    fun navigateByReplace(type: NavigateScreenType) {
        _navigateByReplace.value = type
    }

    fun navigateByAdd(type: NavigateScreenType) {
        _navigateByAdd.value = type
    }
}
