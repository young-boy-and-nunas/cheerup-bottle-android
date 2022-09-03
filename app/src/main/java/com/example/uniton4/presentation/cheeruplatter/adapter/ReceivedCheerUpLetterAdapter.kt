package com.example.uniton4.presentation.cheeruplatter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity

class ReceivedCheerUpLetterAdapter(
    private val listener: ReceivedCheerUpLetterListener
): ListAdapter<ReceivedCheerUpLetterEntity, ReceivedCheerUpLetterViewHolder>(DiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceivedCheerUpLetterViewHolder {
        return ReceivedCheerUpLetterViewHolder.from(parent, listener)
    }

    override fun onBindViewHolder(holder: ReceivedCheerUpLetterViewHolder, position: Int) {
       holder.bind(getItem(position))
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<ReceivedCheerUpLetterEntity>() {
        override fun areItemsTheSame(oldItem: ReceivedCheerUpLetterEntity, newItem: ReceivedCheerUpLetterEntity): Boolean {
            return oldItem.cheerId == newItem.cheerId
        }

        override fun areContentsTheSame(oldItem: ReceivedCheerUpLetterEntity, newItem: ReceivedCheerUpLetterEntity): Boolean {
            return false
        }
    }
}
