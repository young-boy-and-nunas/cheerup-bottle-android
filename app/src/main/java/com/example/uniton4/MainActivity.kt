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
        viewModel.navigateByReplace.observe(this) { type ->
            replaceFragment(type)
        }

        viewModel.navigateByAdd.observe(this) { type ->
            addFragment(type)
        }
    }

    private fun replaceFragment(type: NavigateScreenType) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, type.fragment)
            .commit()
    }

    private fun addFragment(type: NavigateScreenType) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, type.fragment, /* tag = */ type.name)
            .addToBackStack(type.name)
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
