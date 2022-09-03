package com.example.uniton4.data

import com.example.uniton4.data.request.LoginRequest
import com.example.uniton4.data.request.SignUpRequest
import com.example.uniton4.domain.RandomWorryEntity
import com.example.uniton4.domain.UserEntity
import okhttp3.MultipartBody
import retrofit2.http.*
import com.example.uniton4.domain.LoginEntity
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

    @POST("/login")
    suspend fun login(
        @Body body: LoginRequest
    ):LoginEntity

    @Multipart
    @POST("/worry")
    suspend fun createWorry(
        @Header("Authorization") auth: String,
        @Query("contents") contents: String?,
        @Part("imgUrl") imgUrl: MultipartBody.Part?,
        @Query("userSeq") userSeq: String?,
    )

    @GET("/user")
    suspend fun getUser(
        @Header("Authorization") auth: String,
    ): UserEntity

    @DELETE("/user")
    suspend fun withThrowUser(
        @Header("Authorization") auth: String,
    )

    @Multipart
    @POST("/cheer/cheer")
    suspend fun makeCheer(
        @Header("Authorization") auth: String,
        @Query("contents") contents: String,
        @Part("audioMultipartFile") audioMultipartFile: MultipartBody.Part?,
        @Part("imageMultipartFile") imageMultipartFile: MultipartBody.Part?,
        @Query("imgUrl") imgUrl: String,
        @Query("audioUrl") audioUrl: String,
        @Query("userId") userId: Int,
        @Query("worryId") worryId: Int,
    )

    @GET("/cheer/select/20")
    suspend fun selectLimit20Cheer(
        @Header("Authorization") auth: String,
    )

    @POST("/cheer/update-check")
    suspend fun updateCheck(
        @Query("cheerSeq") cheerSeq: Int
    )
}
