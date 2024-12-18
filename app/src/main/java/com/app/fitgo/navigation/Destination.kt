package com.app.fitgo.navigation

import kotlinx.serialization.Serializable

sealed class Destination{

    @Serializable
    data object Splash

    @Serializable
    data object Onboarding

    @Serializable
    data object Login

    @Serializable
    data object Home

    @Serializable
    data object Explore

    @Serializable
    data object Chats

    @Serializable
    data object Profile

    @Serializable
    data object Trainer

    @Serializable
    data object Notification

    @Serializable
    data object Setting

    @Serializable
    data object CreatePost

    @Serializable
    data class ChatDetail(val chatId: String)

    @Serializable
    data object Follower

    @Serializable
    data object MyPost

}