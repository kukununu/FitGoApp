package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.create_post.CreatePostScreen
import com.app.fitgo.presentation.create_post.CreatePostViewModel
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.HandleUiEvents
import com.app.fitgo.utils.ObserveLifecycleEvents

fun NavGraphBuilder.createPostDestination(
    onNavigateToBack: () -> Unit,
    onNavigateToHome: () -> Unit,
){

    composable<Destination.CreatePost>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){
        val context = LocalContext.current

        val viewModel: CreatePostViewModel = hiltViewModel()

        val state by viewModel.state.collectAsStateWithLifecycle()

        HandleUiEvents(viewModel.uiEvent,context)

        ObserveLifecycleEvents { event ->
            when(event){
                is Event.NavigateToHome -> {
                    onNavigateToHome()
                }
            }
        }

        CreatePostScreen(
            state = state,
            onEvent = viewModel::onCreateEvent,
            onNavigateToBack = onNavigateToBack
        )
    }
}