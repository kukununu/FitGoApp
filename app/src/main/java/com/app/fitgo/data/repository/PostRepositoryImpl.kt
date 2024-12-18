package com.app.fitgo.data.repository

import com.app.fitgo.data.database.PostDao
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(
    private val postDao: PostDao
) : PostRepository{

    override suspend fun addPost(postData: PostData) {
        return postDao.addPost(postData)
    }

    override suspend fun addPosts(posts: List<PostData>) {
        return postDao.addPosts(posts)
    }

    override fun getPosts(): Flow<List<PostData>> {
        return postDao.getPosts()
    }
}