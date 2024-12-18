package com.app.fitgo.presentation.explore

import com.app.fitgo.domain.model.ChallengeData
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.model.ShortWorkoutData
import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.domain.model.UserData

data class ExploreUiState(
    val isLoading: Boolean = true,
    val trainers: List<TrainerData> = emptyList(),
    val previousTrainers: List<TrainerData> = emptyList(),
    val shortWorkoutList: List<ShortWorkoutData> = emptyList(),
    val challenges: List<ChallengeData> = emptyList(),
    val user: UserData = UserData(),
    val error: String? = null
)