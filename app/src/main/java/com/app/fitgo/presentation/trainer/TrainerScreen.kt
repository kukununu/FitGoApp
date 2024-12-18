package com.app.fitgo.presentation.trainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultSearch
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.trainer.components.TrainerItem2

@Composable
fun TrainerScreen(
    uiState: TrainerUiState,
    state: TrainerState,
    onEvent: (TrainerEvent) -> Unit
) {
    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                "Trainers",
                onBackPress = {
                    onEvent(TrainerEvent.BackPress)
                }
            )
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
                    onEvent(TrainerEvent.EnterSearch(it))
                }
            )
            TrainerScreenContent(uiState,onEvent)
        }
    }

}

@Composable
fun TrainerScreenContent(
    uiState: TrainerUiState,
    onEvent: (TrainerEvent) -> Unit
) {
    if (uiState.isLoading) {
        DefaultLoadingState()
    }else{
        LazyColumn(
            contentPadding = PaddingValues(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.trainers, key = { it.id }){
                TrainerItem2(it,onEvent)
            }
        }
    }
}