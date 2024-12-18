package com.app.fitgo.presentation.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.app.fitgo.R
import com.app.fitgo.data.test_data.TestingData.samplePostDataLists
import com.app.fitgo.domain.model.PostData
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.presentation.components.PulseAnimation
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey2
import com.app.fitgo.ui.theme.Grey3

@Composable
fun HomeItem(
    postData: PostData
) {

    var imageLoadResult by remember{
        mutableStateOf<Result<Painter>?>(null)
    }

    var isLoading by remember{ mutableStateOf(false)}

    val painter = rememberAsyncImagePainter(
        model = postData.image,
        onSuccess = {   Result.success(it.painter)
//
//            val size = it.painter.intrinsicSize
//            imageLoadResult = if (size.width > 1 && size.height > 1){
//                Result.success(it.painter)
//            }else{
//                Result.failure(Exception("Invalid image dimensions"))
//            }
        },
        onError = {
            it.result.throwable.printStackTrace()
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey1, RoundedCornerShape(16.dp))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HomeItemTop(postData)
            VerticalSpacer()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .background(Color.Transparent, RoundedCornerShape(16.dp))
            ) {
                AnimatedContent(
                    targetState = isLoading, label = ""
                ) { it ->
                    if (it){
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            PulseAnimation(modifier = Modifier.size(60.dp))
                        }
                    }else{
                        AsyncImage(
                            model = postData.image ,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop,
                            onLoading = {
                                isLoading = true
                            },
                            onSuccess = {
                                it.result
                                isLoading = false

                            }
                        )
                    }
                }

            }
            VerticalSpacer()
            Text(
                text = postData.content,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            VerticalSpacer()
            HomeBottomCard()
        }

    }
}

//@Composable
//fun productLoadingTransition(): AnimatedContentScope<Boolean>.() -> ContentTransform = {
//
//    slideInVertically(
//        initialOffsetY = { -500 },
//        animationSpec = tween(150,0))  with
//            fadeOut(animationSpec = tween(150)) using
//            SizeTransform { initialSize, targetSize ->
//                keyframes {
//                    IntSize(initialSize.)
//                }
//
//            }
//
//
//}

@Composable
fun HomeBottomCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey, RoundedCornerShape(12.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomIcon(
                    icon = R.drawable.heart,
                    text = "2.5K",
                    iconColor = Color(0XFFDD3131),
                    onClick = {}
                )
                BottomIcon(
                    icon = R.drawable.comment,
                    text = "1.2K",
                    onClick = {}
                )
                BottomIcon(
                    icon = R.drawable.share,
                    text = "100K",
                    onClick = {}
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.send),
                    contentDescription = "Send",
                    modifier = Modifier
                        .size(32.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun BottomIcon(
    icon: Int,
    text: String,
    iconColor: Color = Grey2,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(icon),
                contentDescription = "Like",
                modifier = Modifier.size(32.dp),
                tint = iconColor
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall
                .copy(
                    color = Color.White
                )
        )
    }

}

@Composable
fun HomeItemTop(
    postData: PostData
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        ){
            AsyncImage(
                postData.profileImg,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        HorizontalSpacer(8.dp)
        Column {
            Text(
                text = postData.name,
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
            VerticalSpacer(4.dp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "2 hour ago",
                    style = MaterialTheme.typography.labelSmall,
                    color = Grey3
                )
                HorizontalSpacer()
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(Color.White, CircleShape)
                    )
                    HorizontalSpacer(2.dp)
                    Text(
                        text = postData.location,
                        style = MaterialTheme.typography.labelSmall,
                        color = Grey2
                    )
                }

            }
        }
    }


}


@Preview
@Composable
private fun HomeItemTopPreview() {
    FitGoTheme {
        HomeItemTop(samplePostDataLists[0])
    }

}

@Preview
@Composable
private fun HomeItemPreview() {
    FitGoTheme {
        HomeItem(samplePostDataLists[0])
    }

}