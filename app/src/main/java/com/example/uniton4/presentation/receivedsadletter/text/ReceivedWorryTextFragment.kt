package com.example.uniton4.presentation.receivedsadletter.text

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uniton4.R


class ReceivedWorryTextFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_received_worry_text, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedWorryTextFragment()
    }
}