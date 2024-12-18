package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.chat_detail.ChatDetailEvent
import com.app.fitgo.presentation.chat_detail.ChatDetailScreen
import com.app.fitgo.presentation.chat_detail.ChatDetailViewModel

fun NavGraphBuilder.chatDetailDestination(
    onNavigateToBack: () -> Unit
){

    composable<Destination.ChatDetail>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: ChatDetailViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val state by viewModel.state.collectAsStateWithLifecycle()

        ChatDetailScreen(
            uiState = uiState,
            state = state,
            onEvent = { event ->
                when(event){
                    is ChatDetailEvent.BackPress -> onNavigateToBack()
                    else -> Unit
                }
                viewModel.onEvent(event)
            }
        )
    }
}