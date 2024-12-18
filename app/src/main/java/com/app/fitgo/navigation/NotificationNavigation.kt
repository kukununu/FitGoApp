package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.notification.NotificationScreen
import com.app.fitgo.presentation.notification.NotificationViewModel

fun NavGraphBuilder.notificationDestination(
    onNavigateToBack: () -> Unit
){

    composable<Destination.Notification>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: NotificationViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        NotificationScreen(
            uiState = uiState,
            onNavigateToBack = onNavigateToBack
        )
    }
}