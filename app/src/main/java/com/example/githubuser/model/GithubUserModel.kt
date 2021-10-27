package com.example.githubuser.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUserModel (
    val username: String,
    val name: String,
    val avatar: String,
    val company: String,
    val location: String,
    val repository: Long,
    val follower: Long,
    val following: Long
) : Parcelable