package com.app.fitgo.presentation.chats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.fitgo.domain.model.ChatUser
import com.app.fitgo.presentation.chats.components.ChatItem
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultSearch
import com.app.fitgo.presentation.components.DefaultTopAppBar

@Composable
fun ChatsScreen(
    uiState: ChatUiState,
    state: ChatState,
    onEvent: (ChatEvent) -> Unit
) {

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar("Chats")
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            DefaultSearch(
                value = state.search,
                placeHolder = "Search",
                onValue = {
                    onEvent(ChatEvent.EnterSearch(it))
                },
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onEvent(ChatEvent.Search)
                    }
                )
            )
            if (uiState.isLoading) {
                DefaultLoadingState()
            }else{
                ChartScreenContent(
                    chats = uiState.chats,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onEvent(ChatEvent.NavigateToChat(it))
                    }
                    )
            }

        }
    }

}

@Composable
fun ChartScreenContent(
    chats: List<ChatUser>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(chats,key = { it.userId }){
            ChatItem(it){
                onClick(it.chatId)
            }
        }
    }

}