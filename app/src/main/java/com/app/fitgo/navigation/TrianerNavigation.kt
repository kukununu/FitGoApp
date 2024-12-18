package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.trainer.TrainerEvent
import com.app.fitgo.presentation.trainer.TrainerScreen
import com.app.fitgo.presentation.trainer.TrainerViewModel
import com.app.fitgo.utils.HandleUiEvents

fun NavGraphBuilder.trainerDestination(
    onNavigateToBack: () -> Unit
){

    composable<Destination.Trainer>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){
        val context= LocalContext.current

        val viewModel: TrainerViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val state by viewModel.state.collectAsStateWithLifecycle()

        HandleUiEvents(viewModel.uiEvent,context)

        TrainerScreen(
            uiState = uiState,
            state = state,
            onEvent = { event ->
                when(event){
                    is TrainerEvent.BackPress -> onNavigateToBack()
                    else -> Unit
                }
                viewModel.onEvent(event)
            }
        )
    }
}