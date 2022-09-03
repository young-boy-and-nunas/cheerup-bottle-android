package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import com.example.uniton4.domain.RandomWorryEntity
import kotlinx.coroutines.flow.first
import okhttp3.MultipartBody
import java.lang.Exception
import javax.inject.Inject

class WorryRepository @Inject constructor(
    private val serviceApi: ServiceApi,
    private val localRepository: LocalRepository
) {
    suspend fun getRandomWorry(): Result<RandomWorryEntity> {
        return try {
            Result.success(
                serviceApi.getRandomWorry(
                    "Bearer ${localRepository.getUserKey().first() ?: ""}"
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createWorry(
        contents: String? = null,
        imgUrl: MultipartBody.Part? = null
    ): Result<Boolean> {
        return try {
            serviceApi.createWorry(
                "Bearer ${localRepository.getUserKey().first() ?: ""}",
                contents = contents,
            )

            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
