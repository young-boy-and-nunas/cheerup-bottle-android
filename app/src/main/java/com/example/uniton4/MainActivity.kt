package com.example.uniton4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        navigateToFragment(checkLoginState())
        observe()
    }

    private fun observe() {
        viewModel.navigateType.observe(this) { type ->
            replaceFragment(type)
        }
    }

    private fun replaceFragment(type: NavigateScreenType) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, type.fragment)
            .commit()
    }

    private fun addFragment(type: NavigateScreenType) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, type.fragment)
            .commit()
    }

    private fun navigateToFragment(isLoggedIn: Boolean) {
        when {
            isLoggedIn -> addFragment(NavigateScreenType.RECEIVED_SAD_LETTER)
            else -> addFragment(NavigateScreenType.LOGIN)
        }
    }

    private fun checkLoginState(): Boolean = false
}
