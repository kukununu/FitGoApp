package com.app.fitgo.presentation.chats

import com.app.fitgo.domain.model.ChatUser

data class ChatUiState(
    val isLoading: Boolean = true,
    val chats: List<ChatUser> = emptyList(),
    val previousChats: List<ChatUser> = emptyList(),
    val error: String? = null
)