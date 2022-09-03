package com.example.uniton4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uniton4.presentation.LoginFragment
import com.example.uniton4.presentation.ReceivedSadLetterFragment
import com.example.uniton4.presentation.cheeruplatter.ReceivedCheerUpLetterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ReceivedCheerUpLetterFragment.newInstance())
            .commit()

       // navigateToFragment(checkLoginState())
    }

    private fun navigateToFragment(isLoggedIn: Boolean) {
        when {
            isLoggedIn -> startReceivedSadLetterFragment()
            else -> startLoginFragment()
        }
    }

    private fun checkLoginState(): Boolean = false

    private fun startLoginFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LoginFragment.newInstance())
            .commit()
    }

    private fun startReceivedSadLetterFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ReceivedSadLetterFragment.newInstance())
            .commit()
    }
}
