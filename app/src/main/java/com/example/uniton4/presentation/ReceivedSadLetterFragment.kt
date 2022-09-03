package com.example.uniton4.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uniton4.R

class ReceivedSadLetterFragment private constructor() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_received_sad_letter, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedSadLetterFragment()
    }
}