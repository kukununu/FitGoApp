package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.login.LoginScreen
import com.app.fitgo.presentation.login.LoginViewModel
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.HandleUiEvents
import com.app.fitgo.utils.ObserveLifecycleEvents

fun NavGraphBuilder.loginDestination(
    onNavigateToHome: () -> Unit
){

    composable<Destination.Login>(){

        val context = LocalContext.current

        val viewModel: LoginViewModel = hiltViewModel()

        val state by viewModel.state.collectAsStateWithLifecycle()

        HandleUiEvents(viewModel.uiEvent,context)

        ObserveLifecycleEvents { event ->
            when(event){
                is Event.NavigateToHome -> {
                    onNavigateToHome()
                }
            }
        }

        LoginScreen(
            state = state,
            onEvent = viewModel::onLoginEvent
        )
    }
}