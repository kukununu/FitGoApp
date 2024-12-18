package com.app.fitgo.presentation.my_post

import com.app.fitgo.domain.model.PostData

data class PostUiState(
    val isLoading: Boolean = true,
    val posts: List<PostData> = emptyList(),
    val error: String? = null
)