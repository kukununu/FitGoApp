package com.app.fitgo.presentation.chat_detail

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.domain.model.ChatMessage
import com.app.fitgo.presentation.components.ButtonLoadingState
import com.app.fitgo.presentation.components.DefaultLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.EmptyState
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.Green
import com.app.fitgo.ui.theme.Grey2
import kotlinx.coroutines.delay

@Composable
fun ChatDetailScreen(
    uiState: ChatDetailUiState,
    state: ChatDetailState,
    onEvent: (ChatDetailEvent) -> Unit,

    ) {

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                "Prakash Mohan",
                onBackPress = {
                    onEvent(ChatDetailEvent.BackPress)
                }
            )
        },
        bottomBar= {
            BottomChat(
                state = state,
                onEvent = onEvent
            )
        }
    ) {
        if (uiState.isLoading){
            DefaultLoadingState()
        }else{
            if (uiState.chats.isNotEmpty()){
                ChatLazyColumn(uiState.chats)
            }else{
                EmptyState("No chart found")
            }

        }
    }
}


@Composable
fun ChatLazyColumn(
    messages : List<ChatMessage>
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp,bottom = 80.dp),
        verticalArrangement = Arrangement.Bottom,
        reverseLayout = false
    ) {

        items(messages){ message ->
            if (!message.isSentByUser){
                MessageItemNew(message)

            }else{
                MessageItem1New(message)
            }
        }
    }

    // Scroll to bottom when a new message is added
    LaunchedEffect(messages.size) {
        listState.animateScrollToItem(messages.lastIndex) // Automatically scroll to the latest message
    }
}


@Composable
fun BottomChat(
    state: ChatDetailState,
    onEvent: (ChatDetailEvent) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey)
            .navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = state.message,
                onValueChange = {
                    onEvent(ChatDetailEvent.EnterSearch(it))
                },
                placeholder = {
                    Text(
                        text = "Start typing...",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Grey2
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = BackgroundGrey1,
                    unfocusedContainerColor = BackgroundGrey1,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White.copy(0.8f)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f),
                singleLine = true
            )
            HorizontalSpacer()
            Card(
                onClick = {
                    onEvent(ChatDetailEvent.Send)
                },
                modifier = Modifier
                    .width(120.dp)
                    .height(48.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Green
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Send",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    HorizontalSpacer()
                    if (state.isLoading){
                        ButtonLoadingState()
                    }else{
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }

                }

            }
        }


    }

}


@Composable
fun MessageItemNew(
    message: ChatMessage
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement =  Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = BackgroundGrey
            ),
            shape = RoundedCornerShape(12.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = message.message,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

            }
        }
        HorizontalSpacer()
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    Color(0XFFB8FFF3).copy(0.2f),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                message.profileImg,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MessageItem1New(
    message: ChatMessage
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement =  Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(
                    Color(0XFFB8FFF3).copy(0.2f),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                message.profileImg,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        HorizontalSpacer()
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = BackgroundGrey
            ),
            shape = RoundedCornerShape(12.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = message.message,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun TextTypingAnimation() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Typing",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        HorizontalSpacer(4.dp)
        TypingDotsAnimation()
    }
}

@Composable
fun TypingDotsAnimation() {
    val dotColor = Color.Black
    val dotSize = 5.dp
    val delayBetweenDots = 300L // delay between dots animation

    Row(
        modifier = Modifier
            .height(dotSize)
            .wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(3) { index ->
            AnimatedDot(
                color = dotColor,
                size = dotSize,
                delayMillis = delayBetweenDots * index
            )
        }
    }
}

@Composable
fun AnimatedDot(color: Color, size: Dp, delayMillis: Long) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        delay(delayMillis)
        while (true) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 600, easing = LinearOutSlowInEasing)
            )
            scale.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 600, easing = LinearOutSlowInEasing)
            )
        }
    }

    Box(
        modifier = Modifier
            .size(size)
            .scale(scale.value)
            .background(color, shape = CircleShape)
    )
}