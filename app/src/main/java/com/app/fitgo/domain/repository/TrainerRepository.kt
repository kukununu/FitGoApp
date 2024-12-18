package com.app.fitgo.domain.repository

import com.app.fitgo.domain.model.TrainerData
import kotlinx.coroutines.flow.Flow

interface TrainerRepository {
    suspend fun addTrainers(trainerData: List<TrainerData>)
    fun getTrainers(): Flow<List<TrainerData>>
}