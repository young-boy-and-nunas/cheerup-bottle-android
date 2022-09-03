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

        val targetScreenType = intent.getIntExtra(TARGET_SCREEN, NavigateScreenType.LOGIN.ordinal)
        navigateToFragmentByType(targetScreenType)
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

    private fun navigateToFragmentByType(type: Int) {
        when (type) {
            NavigateScreenType.LOGIN.ordinal -> {
                addFragment(NavigateScreenType.LOGIN)
            }
            NavigateScreenType.RECEIVED_CHEER_UP_LETTER.ordinal -> {
                addFragment(NavigateScreenType.RECEIVED_SAD_LETTER)
            }
        }
    }


    companion object {
        const val TARGET_SCREEN = "target_screen"
    }
}
