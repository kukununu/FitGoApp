package com.app.fitgo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "post_data")
data class PostData(
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val name: String = "",
    val content: String = "",
    val image: String = "",
    val profileImg: String = "",
    val location: String = "",
    val date: String = ""
)


