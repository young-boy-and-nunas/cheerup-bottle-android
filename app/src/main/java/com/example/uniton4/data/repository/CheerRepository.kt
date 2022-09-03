package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import com.example.uniton4.domain.ReceivedCheerUpLetterEntity
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheerRepository @Inject constructor(
    private val localRepository: LocalRepository,
    private val serviceApi: ServiceApi
) {
    suspend fun selectCheers(): Result<List<ReceivedCheerUpLetterEntity>> {
        return try {
            Result.success(
                serviceApi.selectLimit20Cheer(
                    "Bearer ${localRepository.getUserKey().first() ?: ""}"
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateCheck(id: Int): Result<Boolean> {
        return try {
            serviceApi.updateCheck(id)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun makeCheer(
        contents: String,
        worryId: Int
    ): Result<Boolean> {
        return try {
            serviceApi.makeCheer(
                "Bearer ${localRepository.getUserKey().first() ?: ""}",
                contents,
                worryId = worryId
            )
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
