package com.app.fitgo.presentation.chat_detail

sealed interface ChatDetailEvent {
    data class EnterSearch(val message: String): ChatDetailEvent
    data object Send: ChatDetailEvent
    data object BackPress: ChatDetailEvent
}