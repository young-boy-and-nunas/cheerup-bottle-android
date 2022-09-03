package com.example.uniton4.data

import com.example.uniton4.data.request.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceApi {
    @POST("/sign-up/email")
    suspend fun signUp(
        @Body body: SignUpRequest
    )
}
