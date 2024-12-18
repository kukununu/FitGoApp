package com.app.fitgo.presentation.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultSearch
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.presentation.explore.components.ChallengeLazyRow
import com.app.fitgo.presentation.explore.components.ShortWorkoutLazyRow
import com.app.fitgo.presentation.explore.components.StickyHead
import com.app.fitgo.presentation.explore.components.TrainerLazyRow

@Composable
fun ExploreScreen(
    uiState: ExploreUiState,
    state: ExploreState,
    onEvent: (ExploreEvent) ->Unit,
    onNavigateToTrainer: () -> Unit
) {

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar("Explore")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            DefaultSearch(
                value = state.search,
                placeHolder = "Search by trainer",
                onValue = {
                    onEvent(ExploreEvent.EnterSearch(it))
                },
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onEvent(ExploreEvent.Search)
                    }
                )
            )
            if (uiState.isLoading){
                DefaultLoadingState()
            }else{
                VerticalSpacer()
                LazyColumn {
                    item {
                        StickyHead("Trainer", onSeeMore = onNavigateToTrainer )
                        TrainerLazyRow(uiState.trainers){
                            onEvent(ExploreEvent.Favorite(it))
                        }
                        StickyHead("Challeges", onSeeMore = {})
                        ChallengeLazyRow(uiState.challenges)
                        StickyHead("Short Workouts", onSeeMore = {})
                        ShortWorkoutLazyRow(uiState.shortWorkoutList)
                    }
                }
            }



        }
    }

}