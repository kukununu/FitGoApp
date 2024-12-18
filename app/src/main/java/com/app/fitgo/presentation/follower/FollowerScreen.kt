package com.app.fitgo.presentation.follower

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.EmptyState
import com.app.fitgo.presentation.trainer.TrainerEvent
import com.app.fitgo.presentation.trainer.components.TrainerItem2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FollowerScreen(
    uiState: FollowerUiState,
    onEvent: (TrainerEvent) -> Unit,
    onNavigateToBack: () -> Unit
) {

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                "Followers",
                onBackPress = onNavigateToBack
            )
        }
    ) {
        if (uiState.isLoading){
            DefaultLoadingState()
        }else{
            if (uiState.trainers.isEmpty()){
                EmptyState(text = "No followers")
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
    }

}