package com.example.uniton4.data.repository

import com.example.uniton4.data.ServiceApi
import com.example.uniton4.domain.RandomWorryEntity
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class WorryRepository @Inject constructor(
    private val serviceApi: ServiceApi,
    private val localRepository: LocalRepository
) {

    suspend fun getRandomWorry(): RandomWorryEntity {
        return serviceApi.getRandomWorry(
            localRepository.getUserKey().first() ?: ""
        )
    }
}
