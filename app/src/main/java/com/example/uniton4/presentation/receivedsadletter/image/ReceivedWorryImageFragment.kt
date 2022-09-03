package com.example.uniton4.presentation.receivedsadletter.image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uniton4.R
import com.example.uniton4.databinding.FragmentReceivedWorryImageBinding

class ReceivedWorryImageFragment : Fragment() {
    private lateinit var binding: FragmentReceivedWorryImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_received_worry_image, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ReceivedWorryImageFragment()
    }
}