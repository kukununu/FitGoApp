package com.app.fitgo.presentation.notification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.notification.components.NotificationItem

@Composable
fun NotificationScreen(
    uiState: NotificationUiState,
    onNavigateToBack: () -> Unit
) {

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                title = "Notification",
                onBackPress = onNavigateToBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            if (uiState.isLoading){
                DefaultLoadingState()
            }else{
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(uiState.notifications, key = { it.id }){
                        NotificationItem(it)
                    }
                }

            }



        }

    }

}