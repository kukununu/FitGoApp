package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.my_post.PostScreen
import com.app.fitgo.presentation.my_post.PostViewModel

fun NavGraphBuilder.postDestination(
    onNavigateToBack: () -> Unit
){

    composable<Destination.MyPost>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val viewModel: PostViewModel = hiltViewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        PostScreen(
            uiState = uiState,
            onNavigateToBack = onNavigateToBack
        )

    }
}