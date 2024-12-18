package com.app.fitgo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.domain.model.UserData


@Database(entities = [PostData::class,TrainerData::class,UserData::class], version = 1, exportSchema = false)
@TypeConverters(
    StringListTypeConverter::class
)
abstract class FitGoDatabase : RoomDatabase(){
    abstract val postDao : PostDao
    abstract val userDao : UserDao
    abstract val trainerDao : TrainerDao


    companion object {
        const val DATABASE_NAME = "fit_go_db"

    }

}