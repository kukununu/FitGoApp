package com.app.fitgo.presentation.chats

sealed interface ChatEvent{
    data class EnterSearch(val search: String): ChatEvent
    data object Search: ChatEvent
    data class NavigateToChat(val id: String): ChatEvent
    data object BackPress: ChatEvent
}