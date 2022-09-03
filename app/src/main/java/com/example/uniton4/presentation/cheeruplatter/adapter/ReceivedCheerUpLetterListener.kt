package com.example.uniton4.presentation.cheeruplatter.adapter

import com.example.uniton4.domain.RandomWorryEntity

interface ReceivedCheerUpLetterListener {
    fun onClickLetter(dto: RandomWorryEntity)
}
