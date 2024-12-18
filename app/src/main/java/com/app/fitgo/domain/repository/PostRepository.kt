package com.app.fitgo.domain.repository

import com.app.fitgo.domain.model.PostData
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun addPost(postData: PostData)

    suspend fun addPosts(posts: List<PostData>)

    fun getPosts() : Flow<List<PostData>>

}