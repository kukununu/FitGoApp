package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.chats.ChatEvent
import com.app.fitgo.presentation.chats.ChatViewModel
import com.app.fitgo.presentation.chats.ChatsScreen

fun NavGraphBuilder.chatsDestination(
    onNavigateToChat: (String) -> Unit,
    onNavigateToBack: () -> Unit,
){

    composable<Destination.Chats>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: ChatViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val state by viewModel.state.collectAsStateWithLifecycle()

        ChatsScreen(
            uiState = uiState,
            state = state,
            onEvent = { event ->
                when(event){
                    is ChatEvent.NavigateToChat -> {
                        onNavigateToChat(event.id)
                    }
                    is ChatEvent.BackPress -> onNavigateToBack()
                    else -> Unit
                }
                viewModel.onEvent(event)
            }
        )
    }
}