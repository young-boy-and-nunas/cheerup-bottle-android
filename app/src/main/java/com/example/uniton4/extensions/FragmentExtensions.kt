package com.example.uniton4.extensions

import androidx.fragment.app.Fragment

internal fun Fragment.closeSelf() {
    parentFragmentManager.beginTransaction().remove(this).commit()
}
