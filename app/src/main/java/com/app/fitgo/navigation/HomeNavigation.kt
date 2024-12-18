package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.home.HomeScreen
import com.app.fitgo.presentation.home.HomeViewModel

fun NavGraphBuilder.homeDestination(
    onNavigateToNotification: () -> Unit,
    onNavigateToCreatePost: () -> Unit,
){

    composable<Destination.Home>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: HomeViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        HomeScreen(
            uiState = uiState,
            onNavigateToNotification = onNavigateToNotification,
            onNavigateToCreatePost = onNavigateToCreatePost,
        )
    }
}