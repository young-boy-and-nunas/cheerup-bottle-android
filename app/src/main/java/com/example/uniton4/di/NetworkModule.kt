package com.example.uniton4.di

import android.content.Context
import com.example.uniton4.BuildConfig
import com.example.uniton4.data.ServiceApi
import com.example.uniton4.data.repository.LocalRepository
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.firstOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        // log
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }

        // header
        builder.addInterceptor { chain ->
            val newRequest = chain
                .request()
                .newBuilder()
                .build()

            chain.proceed(newRequest)
        }

        // timeout
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.connectTimeout(10, TimeUnit.SECONDS)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://3.39.220.225")
            .client(okHttpClient)
            .addConverterFactory(createGsonConverter())
            .build()
    }

    private fun createGsonConverter(): Converter.Factory {
        val gsonBuilder = GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return GsonConverterFactory.create(gsonBuilder.create())
    }

    @Singleton
    @Provides
    fun provideService(
        retrofit: Retrofit
    ): ServiceApi = retrofit.create(ServiceApi::class.java)
}
