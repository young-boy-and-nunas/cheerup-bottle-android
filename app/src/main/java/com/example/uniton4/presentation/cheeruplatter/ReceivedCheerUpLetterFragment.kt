package com.example.uniton4.presentation.cheeruplatter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uniton4.databinding.FragmentReceivedCheerupLetterBinding
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity
import com.example.uniton4.presentation.cheeruplatter.adapter.ReceivedCheerUpLetterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceivedCheerUpLetterFragment: Fragment() {
    lateinit var binding: FragmentReceivedCheerupLetterBinding
    private val adapter by lazy {
        ReceivedCheerUpLetterAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReceivedCheerupLetterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        adapter.submitList(createMockData())
    }

    private fun createMockData(): List<ReceivedCheerUpLetterEntity> {
        return listOf(
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),
            ReceivedCheerUpLetterEntity(
                id = "1",
                title = "gd",
                description = "asdlgkjasdk",
                image = ""
            ),

        )
    }
    
    companion object {
        fun newInstance() = ReceivedCheerUpLetterFragment()
    }
}
