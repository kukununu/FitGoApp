package com.app.fitgo.presentation.chat_detail

import com.app.fitgo.domain.model.ChatMessage

data class ChatDetailUiState(
    val isLoading: Boolean = true,
    val chats: List<ChatMessage> = emptyList(),
    val error: String? = null
)