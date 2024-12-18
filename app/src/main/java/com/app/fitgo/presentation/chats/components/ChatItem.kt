package com.app.fitgo.presentation.chats.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.fitgo.data.test_data.ChatList
import com.app.fitgo.domain.model.ChatUser
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey1
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun ChatItem(
    chatUser: ChatUser,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey1, RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(1.dp, LightGreen, CircleShape)
                ){
                    AsyncImage(
                        chatUser.profileImg,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = chatUser.userName,
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                color = Color.White
                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = chatUser.lastMessage,
                        style = MaterialTheme.typography.bodyMedium
                            .copy(
                                color = Grey1
                            )
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                if(chatUser.unreadMessages != 0){
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(LightGreen, CircleShape)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = "${chatUser.unreadMessages}",
                            style = MaterialTheme.typography.titleMedium
                                .copy(
                                    color = Color.Black
                                )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = chatUser.timestamp,
                    style = MaterialTheme.typography.bodyMedium
                        .copy(
                            color = LightGreen
                        )
                )
            }

        }
    }

}


@Preview
@Composable
private fun ChatItemPreview() {
    FitGoTheme {
        ChatItem(
            chatUser = ChatList.chatUsers.first(),
            onClick = {}
        )
    }

}