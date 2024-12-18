package com.app.fitgo.presentation.chats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.data.test_data.ChatList
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
class ChatViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState = _uiState
        .onStart {
            getChatList()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private val _state = MutableStateFlow(ChatState())
    val state  = _state.asStateFlow()

    private fun getChatList(){
        viewModelScope.launch {
            delay(1500)
            _uiState.update { it.copy(
                isLoading = false,
                chats = ChatList.chatUsers,
                previousChats = ChatList.chatUsers,
            ) }
        }
    }

    fun onEvent(event: ChatEvent){
        when(event){
            is ChatEvent.EnterSearch -> {
                _state.update { it.copy(search = event.search) }
                _uiState.update { it.copy(
                    chats = _uiState.value.previousChats.filter { it.userName.contains(event.search,ignoreCase = true)}
                )}
            }
            ChatEvent.Search -> {
                _uiState.update { it.copy(
                    chats = _uiState.value.previousChats.filter { it.userName.contains(_state.value.search,ignoreCase = true)}
                )}
            }
            else -> Unit
        }
    }
}