package com.app.fitgo.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.domain.repository.PostRepository
import com.app.fitgo.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository
):ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState
        .onStart {
            getPosts()
            getUser()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )
    private fun getUser(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(1500L)
               val users =  userRepository.getUsers()
                   if (users.isNotEmpty()){
                       _uiState.update { it.copy(user = users[0]) }
                   }

            }catch (e: Exception){

            }
        }
    }


    private fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(1500L)
                postRepository.getPosts()
                    .onEach { posts ->
                        _uiState.update { it.copy(isLoading = false, posts = posts) }
                    }.launchIn(viewModelScope)
                Log.d("data","data${_uiState.value.posts}")

            }catch (e: Exception){
                Log.d("data","error ${e.message}")
                _uiState.update { it.copy(isLoading = false, error = e.message) }

            }
        }
    }
}