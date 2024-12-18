package com.app.fitgo.presentation.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.domain.model.ChallengeData
import com.app.fitgo.domain.model.ShortWorkoutData
import com.app.fitgo.ui.theme.BackgroundGrey1

@Composable
fun ChallengeItem(challengeData: ChallengeData) {

    Box(
        modifier = Modifier
            .width(220.dp)
            .height(140.dp)
            .background(
                Color.Transparent,
                RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            challengeData.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()

        )
        Box(
            modifier = Modifier
                .width(220.dp)
                .height(30.dp)
                .background(BackgroundGrey1.copy(0.6f))
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = challengeData.title,
                style = MaterialTheme.typography.labelSmall
                    .copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
            )
        }

    }

}


@Composable
fun ShorWorkoutItem(shortWorkoutData: ShortWorkoutData) {

    Box(
        modifier = Modifier
            .width(220.dp)
            .height(140.dp)
            .background(
                Color.Transparent,
                RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            shortWorkoutData.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()

        )
        Box(
            modifier = Modifier
                .width(220.dp)
                .height(30.dp)
                .background(BackgroundGrey1.copy(0.6f))
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = shortWorkoutData.title,
                style = MaterialTheme.typography.labelSmall
                    .copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
            )
        }

    }

}