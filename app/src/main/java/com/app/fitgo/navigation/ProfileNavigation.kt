package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.profile.ProfileScreen
import com.app.fitgo.presentation.profile.ProfileViewModel

fun NavGraphBuilder.profileDestination(
    onNavigateToSetting: () -> Unit,
    onNavigateToPost: () -> Unit,
    onNavigateToFollower: () -> Unit,
){

    composable<Destination.Profile>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: ProfileViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        ProfileScreen(
            uiState = uiState,
            onNavigateToSetting = onNavigateToSetting,
            onNavigateToPost = onNavigateToPost,
            onNavigateToFollower = onNavigateToFollower,

        )
    }
}