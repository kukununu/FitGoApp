package com.app.fitgo.navigation

import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.setting.SettingEvent
import com.app.fitgo.presentation.setting.SettingScreen
import com.app.fitgo.presentation.setting.SettingViewModel
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.HandleUiEvents
import com.app.fitgo.utils.ObserveLifecycleEvents

fun NavGraphBuilder.settingDestination(
    onNavigateToBack: () -> Unit,
    onNavigateTLogin: () -> Unit,
){

    composable<Destination.Setting>(
        enterTransition = {
            defaultEnterTransition()
        },
        exitTransition = {
            defaultExitTransition()
        }
    ){

        val context = LocalContext.current

        val viewModel: SettingViewModel = hiltViewModel()

        val state by viewModel.state.collectAsStateWithLifecycle()

        HandleUiEvents(viewModel.uiEvent,context)

        ObserveLifecycleEvents { event ->
            when(event){
                is Event.NavigateToLogin -> {
                    onNavigateTLogin()
                }
            }
        }

        SettingScreen(
            state = state,
            onEvent = { event ->
                when(event){
                    is SettingEvent.BackPress -> onNavigateToBack()
                    else -> Unit
                }
                viewModel.onEvent(event)
            }
        )
    }
}