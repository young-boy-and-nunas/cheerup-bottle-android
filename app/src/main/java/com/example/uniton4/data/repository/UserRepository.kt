package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import com.example.uniton4.domain.UserEntity
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val localRepository: LocalRepository,
    private val serviceApi: ServiceApi,
) {

    suspend fun getUser(): Result<UserEntity> {
        return try {
            Result.success(
                serviceApi.getUser(
                    "Bearer ${localRepository.getUserKey().first() ?: ""}"
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun withThrowUser(): Result<Boolean> {
        return try {
            serviceApi.withThrowUser(
                "Bearer ${localRepository.getUserKey().first() ?: ""}"
            )
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
