package com.app.fitgo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Trainer_data")
data class TrainerData(
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val profileImg: String = "",
    val name: String = "",
    val specialty: String = "",
    val experience: String = "",
    val rating: Int = 0,
    var isFollowed: Boolean = false,
    val date: String = ""
)