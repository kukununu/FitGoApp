package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.explore.ExploreScreen
import com.app.fitgo.presentation.explore.ExploreViewModel
import com.app.fitgo.utils.HandleUiEvents

fun NavGraphBuilder.exploreDestination(
    onNavigateToTrainer: () -> Unit
){

    composable<Destination.Explore>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val context = LocalContext.current

        val viewModel: ExploreViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val state by viewModel.state.collectAsStateWithLifecycle()

        HandleUiEvents(viewModel.uiEvent,context)

        ExploreScreen(
            uiState,
            state,
            viewModel::onEvent,
            onNavigateToTrainer
        )
    }
}