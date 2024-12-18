package com.app.fitgo.presentation.create_post

sealed interface CreatePostEvent{
    data class EnterImage(val image: String): CreatePostEvent
    data class EnterContent(val content: String): CreatePostEvent
    data object Upload: CreatePostEvent
}