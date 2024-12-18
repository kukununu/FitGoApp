package com.app.fitgo.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.domain.model.UserData
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(postData: PostData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPosts(posts: List<PostData>)

    @Query("SELECT * FROM post_data ORDER BY date DESC")
    fun getPosts() : Flow<List<PostData>>

}


@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userData: UserData)

    @Update
    suspend fun updateUserData(userData: UserData)

    @Query("SELECT * FROM user_data")
    fun getUsers() : List<UserData>

    @Query("DELETE FROM user_data WHERE id = :id")
    suspend fun deleteById(id: String)


}

@Dao
interface TrainerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrainers(trainer: List<TrainerData>)

    @Query("SELECT * FROM trainer_data ORDER BY date DESC")
    fun getTrainers() : Flow<List<TrainerData>>

}