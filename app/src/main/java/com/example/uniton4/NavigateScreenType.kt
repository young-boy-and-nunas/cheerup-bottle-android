package com.example.uniton4

import androidx.fragment.app.Fragment
import com.example.uniton4.presentation.login.LoginFragment
import com.example.uniton4.presentation.receivedsadletter.ReceivedSadLetterFragment
import com.example.uniton4.presentation.cheeruplatter.ReceivedCheerUpLetterFragment
import com.example.uniton4.presentation.join.JoinFragment
import com.example.uniton4.presentation.receivedsadletter.ReceivedSadLetterDialogFragment
import com.example.uniton4.presentation.setting.SettingFragment
import com.example.uniton4.presentation.setting.mypage.MyPageFragment
import com.example.uniton4.presentation.setting.removeaccount.RemoveAccountDialogFragment
import com.example.uniton4.presentation.writesadletter.WriteSadLetterFragment

enum class NavigateScreenType(val fragment: Fragment) {
    WRITE_SED_LETTER(WriteSadLetterFragment.newInstance()),
    RECEIVED_CHEER_UP_LETTER(ReceivedCheerUpLetterFragment.newInstance()),
    RECEIVED_SAD_LETTER(ReceivedSadLetterFragment.newInstance()),
    RECEIVED_SAD_LETTER_DIALOG(ReceivedSadLetterDialogFragment.newInstance()),
    LOGIN(LoginFragment.newInstance()),
    JOIN(JoinFragment.newInstance()),
    SETTING(SettingFragment.newInstance()),
    REMOVE_ACCOUNT(RemoveAccountDialogFragment.newInstance()),
    MYPAGE(MyPageFragment.newInstance())
}
