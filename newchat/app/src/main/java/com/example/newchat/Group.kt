package com.example.newchat


data class Group(
    var id: String = "",
    val groupName: String = "",
    val users: List<String> = listOf()
)