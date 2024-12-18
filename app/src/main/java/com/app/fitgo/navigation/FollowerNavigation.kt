package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.follower.FollowerScreen
import com.app.fitgo.presentation.trainer.TrainerScreen
import com.app.fitgo.presentation.trainer.TrainerViewModel

fun NavGraphBuilder.followerDestination(
    onNavigateToBack: () -> Unit
){

    composable<Destination.Follower>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: TrainerViewModel = hiltViewModel()
        val uiState by viewModel.followerUiState.collectAsStateWithLifecycle()

        FollowerScreen(
            uiState = uiState,
            onEvent = viewModel::onEvent,
            onNavigateToBack = onNavigateToBack
        )
    }
}