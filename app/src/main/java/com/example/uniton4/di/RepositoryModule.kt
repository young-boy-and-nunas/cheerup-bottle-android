package com.example.uniton4.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

//    @Binds
//    @Singleton
//    abstract fun bindsRepository(
//        RepositoryImpl: RepositoryImpl,
//    ): Repository
}

