package com.example.interveiwtask
// Create data classes in separate Kotlin files

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String
)
data class User(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>
)