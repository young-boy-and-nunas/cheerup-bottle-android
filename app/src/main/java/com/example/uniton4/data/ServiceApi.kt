package com.example.uniton4.data
import retrofit2.http.GET

interface ServiceApi {
    @GET("/all")
    suspend fun getAll()
}
