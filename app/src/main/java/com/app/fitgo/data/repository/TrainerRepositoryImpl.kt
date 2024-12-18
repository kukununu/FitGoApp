package com.app.fitgo.data.repository

import com.app.fitgo.data.database.TrainerDao
import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.domain.repository.TrainerRepository
import kotlinx.coroutines.flow.Flow

class TrainerRepositoryImpl(
    private val trainerDao: TrainerDao
): TrainerRepository{
    override suspend fun addTrainers(trainerData: List<TrainerData>) {
        return trainerDao.addTrainers(trainerData)
    }

    override fun getTrainers(): Flow<List<TrainerData>> {
        return trainerDao.getTrainers()
    }
}