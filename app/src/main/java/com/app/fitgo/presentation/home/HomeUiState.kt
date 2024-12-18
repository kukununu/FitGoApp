package com.app.fitgo.presentation.home

import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.model.UserData

data class HomeUiState(
    val isLoading: Boolean = true,
    val posts: List<PostData> = emptyList(),
    val user: UserData = UserData(),
    val error: String? = null
)