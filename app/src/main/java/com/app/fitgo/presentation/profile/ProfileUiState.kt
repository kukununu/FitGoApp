package com.app.fitgo.presentation.profile

import com.app.fitgo.domain.model.UserData

data class ProfileUiState(
    val isLoading: Boolean = true,
    val user: UserData = UserData(),
    val error: String? = null
)