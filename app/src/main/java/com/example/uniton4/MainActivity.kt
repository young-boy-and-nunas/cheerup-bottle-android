package com.example.uniton4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.uniton4.presentation.LoginFragment
import com.example.uniton4.presentation.ReceivedSadLetterFragment
import com.example.uniton4.presentation.cheeruplatter.ReceivedCheerUpLetterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observe()

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container, ReceivedCheerUpLetterFragment.newInstance())
//            .commit()


        replaceFragment(NavigateScreenType.RECEIVED_CHEER_UP_LETTER)
      //   navigateToFragment(checkLoginState())
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
