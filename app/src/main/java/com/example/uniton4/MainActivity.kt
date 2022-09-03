package com.example.uniton4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToFragment(checkLoginState())
    }
    private fun navigateToFragment(isLoggedIn: Boolean){
        when{
            isLoggedIn -> startLoginFragment()
            else -> Unit
        }
    }

    private fun checkLoginState(): Boolean = false

    private fun startLoginFragment(){

    }
}
