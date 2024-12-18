package com.app.fitgo.presentation.follower

import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.domain.model.UserData

data class FollowerUiState(
    val isLoading: Boolean = true,
    val trainers: List<TrainerData> = emptyList(),
    val previousTrainers: List<TrainerData> = emptyList(),
    val user: UserData = UserData(),
    val error: String? = null
)