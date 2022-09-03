package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheerRepository @Inject constructor(
    private val localRepository: LocalRepository,
    private val serviceApi: ServiceApi
) {
    suspend fun selectCheers() {
        return try {
        //    serviceApi.selectLimit20Cheer(localRepository.getUserKey().first() ?: "")
        } catch (e: Exception) {

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

    suspend fun makeCheer(): Result<Boolean> {
        return try {
           // serviceApi.makeCheer()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
