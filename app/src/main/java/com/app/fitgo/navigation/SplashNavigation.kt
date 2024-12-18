package com.app.fitgo.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.fitgo.Constants
import com.app.fitgo.data_store.DataStoreManager
import com.app.fitgo.domain.model.UserData
import com.app.fitgo.presentation.MainViewModel
import com.app.fitgo.presentation.SplashScreen
import kotlinx.coroutines.delay

fun NavGraphBuilder.splashDestination(
    onNavigateToHome: (String) -> Unit
){

    composable<Destination.Splash>(
//        enterTransition = {
//            defaultEnterTransition()
//        },
//        exitTransition = {
//            defaultExitTransition()
//        }
    ){

        val context = LocalContext.current
        val dataStoreManager = DataStoreManager(context)

        val viewModel: MainViewModel = hiltViewModel()
        LaunchedEffect(Unit) {
            val user = dataStoreManager.getValue(Constants.USER_ID,UserData()) as UserData
            delay(2000L)
            onNavigateToHome(user.id)
        }

        SplashScreen()
    }
}