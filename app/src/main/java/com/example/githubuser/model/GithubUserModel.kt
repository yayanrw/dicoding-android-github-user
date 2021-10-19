package com.example.githubuser.model

data class GithubUserModel (
    val username: String,
    val name: String,
    val avatar: String,
    val company: String,
    val location: String,
    val repository: Long,
    val follower: Long,
    val following: Long
)
