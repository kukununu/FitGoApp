package com.app.fitgo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "user_data")
@Serializable
data class UserData(
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val userName: String = "",
    val profileImg: String = "",
    val followers: List<String> = emptyList(),
    val posts: List<String> = emptyList()
)