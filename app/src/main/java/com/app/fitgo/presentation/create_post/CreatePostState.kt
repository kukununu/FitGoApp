package com.app.fitgo.presentation.create_post

data class CreatePostState(
    val isLoading: Boolean = false,
    val image: String = "",
    val content: String = ""
)