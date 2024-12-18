package com.app.fitgo.navigation

import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.presentation.OnboardingScreen
import com.app.fitgo.presentation.login.LoginScreen

fun NavGraphBuilder.onboardingDestination(
    onNavigateToLogin: () -> Unit
){

    composable<Destination.Onboarding>(
        exitTransition = {
            slideOutHorizontally()
        }
    ){

        OnboardingScreen(
            onNavigateToLogin = onNavigateToLogin
        )
    }
}