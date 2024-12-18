package com.app.fitgo.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.fitgo.Constants
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.presentation.profile.components.ProfileCard
import com.app.fitgo.presentation.profile.components.ProfileTopAppBar
import com.app.fitgo.presentation.profile.components.UserCard
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onNavigateToSetting: () -> Unit,
    onNavigateToPost: () -> Unit,
    onNavigateToFollower: () -> Unit,
) {

    DefaultScaffold(
        topAppBar = {
            ProfileTopAppBar {
                Constants.userData = uiState.user
                onNavigateToSetting()
            }
        }
    ) {

        if (uiState.isLoading){
            DefaultLoadingState()
        }else{

            val user = uiState.user
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileCard(user)
                VerticalSpacer()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UserCard(
                        "Posts",
                        "${user.posts.size}",
                        onClick = onNavigateToPost
                    )
                    HorizontalSpacer()
                    UserCard(
                        "Followers",
                        "${user.followers.size}",
                        onClick = onNavigateToFollower
                    )
                    HorizontalSpacer()
                    UserCard(
                        "Following",
                        "180",
                        onClick = {}
                    )
                }
                VerticalSpacer()
                WorkoutTab()

            }
        }




    }

}

@Composable
fun WorkoutTab() {

    var selectedTabIndex by remember{ mutableIntStateOf(0) }
    val pagerState = rememberPagerState { 3 }

    LaunchedEffect(selectedTabIndex){
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    color = LightGreen,
                    modifier = Modifier
                        .width(30.dp)
                        .tabIndicatorOffset(
                            tabPositions[selectedTabIndex]
                        ),
                    height = 6.dp
                )
            },
            containerColor = Color.Transparent,
            divider = {

            }
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = {
                    selectedTabIndex = 0
                },
                modifier = Modifier.weight(1f),
                selectedContentColor = Color.White,
                unselectedContentColor = Color(0XFF676161)
            ) {

                Text(
                    text = "Workouts",
                    style = MaterialTheme.typography.titleMedium.copy(
                   //     color = Color(0XFF676161)
                    ),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            Tab(
                selected = selectedTabIndex == 1,
                onClick = {
                    selectedTabIndex = 1
                },
                modifier = Modifier.weight(1f),
                selectedContentColor = Color.White,
                unselectedContentColor = Color(0XFF676161)
            ) {

                Text(
                    text = "Achievements",
                    style = MaterialTheme.typography.titleMedium.copy(
                   //     color = Color(0XFF676161)
                    ),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            Tab(
                selected = selectedTabIndex == 2,
                onClick = {
                    selectedTabIndex = 2
                },
                modifier = Modifier.weight(1f),
                selectedContentColor = Color.White,
                unselectedContentColor = Color(0XFF676161)
            ) {

                Text(
                    text = "My Posts",
                    style = MaterialTheme.typography.titleMedium.copy(
                  //      color = Color(0XFF676161)
                    ),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(4.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { pageIndex ->

            when(pageIndex){
                0 -> {
                    WorkoutScreen()
                }
                1 -> AchievementScreen()
                2 -> {
                    MyPostScreen()
                }
                else -> WorkoutScreen()
            }
        }
    }



}