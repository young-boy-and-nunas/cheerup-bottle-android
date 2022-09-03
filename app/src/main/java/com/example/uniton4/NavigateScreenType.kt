package com.example.uniton4

import androidx.fragment.app.Fragment
import com.example.uniton4.presentation.login.LoginFragment
import com.example.uniton4.presentation.ReceivedSadLetterFragment
import com.example.uniton4.presentation.cheeruplatter.ReceivedCheerUpLetterFragment
import com.example.uniton4.presentation.join.JoinFragment
import com.example.uniton4.presentation.writesadletter.WriteSadLetterFragment

enum class NavigateScreenType(val fragment: Fragment) {
    WRITE_SED_LETTER(WriteSadLetterFragment.newInstance()),
    RECEIVED_CHEER_UP_LETTER(ReceivedCheerUpLetterFragment.newInstance()),
    RECEIVED_SAD_LETTER(ReceivedSadLetterFragment.newInstance()),
    LOGIN(LoginFragment.newInstance()),
    JOIN(JoinFragment.newInstance())
}
