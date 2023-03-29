package com.example.newchat

data class ChatMessage(
    val message: String = "",
    val sender: String = "",
    val timestamp: Long = 0L,
    val displayName: String = ""
)
