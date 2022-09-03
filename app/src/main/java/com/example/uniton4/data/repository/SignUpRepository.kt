package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import com.example.uniton4.data.request.SignUpRequest
import javax.inject.Inject

class SignUpRepository @Inject constructor(
    private val serviceApi: ServiceApi
) {
    suspend fun signup(request: SignUpRequest): Result<Boolean> {
        return try {
            serviceApi.signUp(request)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
