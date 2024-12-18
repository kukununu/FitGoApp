package com.app.fitgo.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.fitgo.navigation.bottom_navigation.BottomNavigation
import com.app.fitgo.navigation.bottom_navigation.bottomScreens
import com.app.fitgo.ui.theme.Background

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    val showBottomNav = bottomScreens.map { it.route::class }.any { route ->
        currentDestination?.hierarchy?.any {
            it.hasRoute(route)
        } == true
    }

    Scaffold(
        bottomBar = {
            if (showBottomNav) {
                BottomNavigation(navController)
            }
        },
        containerColor = Background,
        contentWindowInsets = WindowInsets(0,0,0,0)
    ) { innerPadding ->

        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Destination.Splash
        ) {

            splashDestination {
                if (it.isEmpty()){
                    navController.navigate(Destination.Onboarding){
                        popUpTo<Destination.Splash>(){
                            inclusive = true
                        }
                    }
                }else{
                    navController.navigate(Destination.Home){
                        popUpTo<Destination.Splash>(){
                            inclusive = true
                        }
                    }
                }

            }

            onboardingDestination {
                navController.navigate(Destination.Login){
                    popUpTo<Destination.Onboarding>(){
                        inclusive = true
                    }
                }
            }

            loginDestination {
                navController.navigate(Destination.Home){
                    popUpTo<Destination.Login>(){
                        inclusive = true

                    }
                    launchSingleTop =true
                }

            }
            homeDestination(
                onNavigateToNotification = {
                    navController.navigate(Destination.Notification)
                },
                onNavigateToCreatePost = {
                    navController.navigate(Destination.CreatePost)
                }
            )
            exploreDestination(
                onNavigateToTrainer = {
                    navController.navigate(Destination.Trainer)
                }
            )
            chatsDestination(
                onNavigateToChat = {
                    navController.navigate(Destination.ChatDetail(it))
                },
                onNavigateToBack = {
                    navController.popBackStack()
                }
            )
            chatDetailDestination {
                navController.popBackStack()
            }
            profileDestination(
                onNavigateToSetting = {
                    navController.navigate(Destination.Setting)
                },
                onNavigateToFollower = {
                    navController.navigate(Destination.Follower)
                },
                onNavigateToPost = {
                    navController.navigate(Destination.MyPost)
                }
            )
            trainerDestination(
                onNavigateToBack = {
                    navController.popBackStack()
                }
            )
            notificationDestination {
                navController.popBackStack()
            }
            settingDestination(
                onNavigateToBack = {
                    navController.popBackStack()
                },
                onNavigateTLogin = {
                    navController.navigate(Destination.Login){
                        popUpTo(0){
                            inclusive = true
                        }
                    }
                }
            )

            createPostDestination(
                onNavigateToBack = {
                    navController.popBackStack()
                },
                onNavigateToHome = {
                    navController.navigate(Destination.Home){
                        popUpTo<Destination.CreatePost>(){
                            inclusive = true
                        }
                    }
                }
            )

            postDestination { navController.popBackStack() }

            followerDestination { navController.popBackStack() }
        }

    }
}