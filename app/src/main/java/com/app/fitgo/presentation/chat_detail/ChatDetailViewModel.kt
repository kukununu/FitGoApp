package com.app.fitgo.presentation.chat_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.data.test_data.ChatList
import com.app.fitgo.domain.model.ChatMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val chatId: String? = savedStateHandle["chatId"]


    private val _uiState = MutableStateFlow(ChatDetailUiState())
    val uiState = _uiState
        .onStart {
            Log.d("data","id called")
            getChatById()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private val _state = MutableStateFlow(ChatDetailState())
    val state = _state.asStateFlow()

    private fun getChatById(){

        viewModelScope.launch {
            try {
                chatId?.let { id ->
                    Log.d("data","id ${id}")
                    val history = ChatList.chatHistory.filter { it.chatId == id }
                    _uiState.update { it.copy(
                        isLoading = false,
                        chats = history
                    ) }
                    Log.d("data","history ${history}")
                }
            }catch (e: Exception){
                _uiState.update { it.copy(
                    isLoading = false,
                    error = e.message
                ) }
                Log.d("data","error ${e.message}")
            }

        }




    }


    fun onEvent(event: ChatDetailEvent){
        when(event){
            is ChatDetailEvent.EnterSearch -> {
                _state.update { it.copy(
                    message = event.message
                ) }
            }
            ChatDetailEvent.Send -> {
                sendMessage()
            }
            else -> Unit
        }
    }


    private fun  sendMessage(){
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val history = _uiState.value.chats.toMutableList()

            val message = ChatMessage(
                chatId = "1",
                messageId = "123",
                senderId = "1233",
                message = _state.value.message,
                timestamp = "Just now",
                isRead = true,
                isSentByUser = false,
                profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"

            )
            history.add(message)
            delay(1000L)
            _uiState.update { it.copy(
                chats = history
            ) }
            _state.update { it.copy(
                message = "",
                isLoading = false
            ) }

        }
    }
}