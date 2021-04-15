package com.demo.userservice.model

data class User(
    val id: String,
    val username: String,
    val email: String?,
    val role: String,
    val groupId: String,
)