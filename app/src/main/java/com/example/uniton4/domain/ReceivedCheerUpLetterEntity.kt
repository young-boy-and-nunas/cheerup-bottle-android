package com.example.uniton4.domain

data class ReceivedCheerUpLetterEntity(
    val audioUrl: String,
    val cheerId: Int,
    val contents: String,
    val imgUrl: String,
    val userId: String,
    val worryDto: RandomWorryEntity,
    val worryId: Int
)
