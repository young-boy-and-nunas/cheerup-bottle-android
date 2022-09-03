package com.example.uniton4.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.uniton4.MainActivity
import com.example.uniton4.MainActivity.Companion.TARGET_SCREEN
import com.example.uniton4.NavigateScreenType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(TARGET_SCREEN, NavigateScreenType.LOGIN.ordinal)
            }
            startActivity(intent)
            finish()
        }, 2000)

        // observe()
        // viewModel.validateUser()
    }

    private fun observe() {
        viewModel.navigateToLogin.observe(this) {
            startScreen(NavigateScreenType.LOGIN.ordinal)
        }

        viewModel.navigateToMain.observe(this) {
            startScreen(NavigateScreenType.RECEIVED_CHEER_UP_LETTER.ordinal)
        }
    }

    private fun startScreen(ordinal: Int) {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(TARGET_SCREEN, ordinal)
            }
            startActivity(intent)
            finish()
        }, 2000)
    }
}
