package com.example.uniton4.data.repository

import android.util.Log
import com.example.uniton4.data.ServiceApi
import com.example.uniton4.data.request.LoginRequest
import com.example.uniton4.domain.LoginEntity
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val serviceApi: ServiceApi,
    private val localRepository: LocalRepository
) {
    suspend fun login(request: LoginRequest): Result<LoginEntity> {
        return try {
            val result = serviceApi.login(request)
            localRepository.setUserKey(result.accessToken)
            return Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}