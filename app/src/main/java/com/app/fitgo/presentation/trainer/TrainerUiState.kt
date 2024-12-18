package com.app.fitgo.presentation.trainer

import com.app.fitgo.domain.model.TrainerData

data class TrainerUiState(
    val isLoading: Boolean = true,
    val trainers: List<TrainerData> = emptyList(),
    val previousTrainers: List<TrainerData> = emptyList(),
    val error: String? = null
)