package com.example.uniton4.presentation.cheeruplatter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uniton4.databinding.ReceivedCheerupLetterItemBinding
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity

class ReceivedCheerUpLetterViewHolder private constructor(
    private val binding: ReceivedCheerupLetterItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(
            parent: ViewGroup,
        ): ReceivedCheerUpLetterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ReceivedCheerupLetterItemBinding.inflate(layoutInflater, parent, false)
            return ReceivedCheerUpLetterViewHolder(binding)
        }
    }

    fun bind(viewData: ReceivedCheerUpLetterEntity) {
        binding.entity = viewData
    }
}
