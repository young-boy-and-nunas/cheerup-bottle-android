package com.example.uniton4.data

import com.example.uniton4.data.request.SignUpRequest
import com.example.uniton4.domain.RandomWorryEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServiceApi {
    @POST("/sign-up/email")
    suspend fun signUp(
        @Body body: SignUpRequest
    )

    @GET("/worry")
    suspend fun getRandomWorry(
        @Header("Authorization") auth: String,
    ): RandomWorryEntity
}
