package com.example.newchat

data class User(
    var id: String? = null,
    var displayName: String? = null,
    var isGroup: Boolean = false
)