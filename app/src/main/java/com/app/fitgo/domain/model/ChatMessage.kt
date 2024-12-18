package com.app.fitgo.domain.model

data class ChatMessage(
    val chatId: String,
    val messageId: String,     // Unique ID for the message
    val senderId: String,      // ID of the sender
    val message: String,       // Message content
    val timestamp: String,        // Time the message was sent (epoch time)
    var isRead: Boolean = false, // Track read/unread status
    val isSentByUser: Boolean,  // Flag to indicate if the message was sent by the user
    val profileImg: String = ""
)

data class ChatUser(
    val chatId: String,
    val userId: String,         // Unique ID for the user
    val userName: String,       // Name of the user
    val profileImg: String = "",// Profile image resource ID (nullable)
    val lastMessage: String,    // Last message exchanged with this user
    val timestamp: String,        // Timestamp of the last message
    val unreadMessages: Int     // Count of unread messages
)