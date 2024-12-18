package com.app.fitgo.presentation.create_post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.domain.repository.PostRepository
import com.app.fitgo.domain.repository.UserRepository
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.EventBus.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val repository: PostRepository

):ViewModel() {

    private val _state = MutableStateFlow(CreatePostState())
    val state = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent = _uiEvent.asSharedFlow()


    fun onCreateEvent(event: CreatePostEvent){
        when(event){
            is CreatePostEvent.EnterImage -> {
                _state.update { it.copy(image = event.image) }
            }
            is CreatePostEvent.EnterContent -> {
                _state.update { it.copy(content = event.content) }
            }
            is CreatePostEvent.Upload -> {
                createPost()
            }
        }
    }


    fun showToast(message: String) {
        viewModelScope.launch {
            _uiEvent.emit(message)
        }
    }

    private fun createPost(){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            val users = userRepository.getUsers()
            if (users.isNotEmpty()){

                val id = UUID.randomUUID().toString()
                val post = PostData(
                    id = id,
                    name = "Jenny Wilson",
                    content = _state.value.content,
                    image = _state.value.image,
                    profileImg = "https://images.unsplash.com/photo-1530882548122-0596ee66cdfd?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                    location = "Chennai,India",
                    date = convertCurrentDate()
                )
                val user = users[0].copy(
                    posts = users[0].posts.toMutableList().apply {
                        this.add(id)
                    }
                )

                repository.addPost(post)
                userRepository.updateUserData(user)
                showToast("Post Created Successfully")
                sendEvent(Event.NavigateToHome)
            }

        }
    }

    private fun convertCurrentDate(): String {
        val currentDate = LocalDate.now() // Get the current date
        val formatter = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH) // Desired output format
        return currentDate.format(formatter) // Format the date to the desired pattern
    }
}