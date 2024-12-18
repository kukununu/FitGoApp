package com.app.fitgo.navigation.bottom_navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.fitgo.R
import com.app.fitgo.navigation.Destination
import com.app.fitgo.ui.theme.Grey4
import com.app.fitgo.ui.theme.LightGreen
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomScreen <T>(
    @StringRes val name: Int,
    @DrawableRes val selectedIcon: Int,
    val route : T
) {

    @Serializable
    data object Home : BottomScreen<Destination.Home>(
        R.string.home,
        R.drawable.home,
        Destination.Home
    )
    @Serializable
    data object Explore : BottomScreen<Destination.Explore>(
        R.string.explore,
        R.drawable.explore,
        Destination.Explore
    )
    @Serializable
    data object Chats : BottomScreen<Destination.Chats>(
        R.string.chats,
        R.drawable.message,
        Destination.Chats
    )
    @Serializable
    data object Profile : BottomScreen<Destination.Profile>(
        R.string.profile,
        R.drawable.img1,
        Destination.Profile
    )

}


val bottomScreens =  listOf(
    BottomScreen.Home,
    BottomScreen.Explore,
    BottomScreen.Chats,
    BottomScreen.Profile
)

@Composable
fun BottomNavigation(
    navController: NavController
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Transparent
    ) {

        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        bottomScreens.forEach { screen ->

            val isSelected =
                currentDestination?.hierarchy?.any { it.hasRoute(screen.route::class) } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.selectedIcon),
                        contentDescription = stringResource(screen.name),
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Column(
                        modifier = Modifier.width(IntrinsicSize.Max),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(screen.name)
                        )
                        if (isSelected) {
                            HorizontalDivider(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                thickness = 2.dp,
                                color = LightGreen
                            )
                        }

                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightGreen,
                    unselectedIconColor = Grey4,
                    selectedTextColor = LightGreen,
                    unselectedTextColor = Grey4,
                    indicatorColor = Color.Transparent
                )

            )
        }
    }
}