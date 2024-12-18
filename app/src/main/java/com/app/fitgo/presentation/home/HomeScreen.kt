package com.app.fitgo.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffoldFabOnly
import com.app.fitgo.presentation.home.components.HomeItem
import com.app.fitgo.presentation.home.components.HomeTopAppBar
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onNavigateToNotification: () -> Unit,
    onNavigateToCreatePost: () -> Unit,
) {

    DefaultScaffoldFabOnly(
        fab = {
            FloatingActionButton(
                onClick = onNavigateToCreatePost,
                containerColor = LightGreen,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
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
                    item {
                        HomeTopAppBar(
                            userData = uiState.user,
                            onNotification = onNavigateToNotification
                        )
                    }
                    items(uiState.posts.sortedBy { it.date }, key = { it.id}){
                        HomeItem(it)
                    }
                }
            }
        }
    }
}