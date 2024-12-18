package com.app.fitgo.presentation.notification

import com.app.fitgo.domain.model.NotificationData
import com.app.fitgo.domain.model.TrainerData

data class NotificationUiState(
    val isLoading: Boolean = true,
    val notifications: List<NotificationData> = emptyList(),
    val error: String? = null
)