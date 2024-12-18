package com.app.fitgo.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.ui.theme.Background

@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
    ) {

        Column {
            Spacer(modifier = Modifier.height(160.dp))
            AsyncImage(
                R.drawable.onboarding3,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
        }
//        Image(
//            painter = painterResource(id = R.drawable.onboarding1),
//            contentDescription = null,
//            modifier = Modifier
//                .padding(20.dp)
//                .size(300.dp)
//                .align(Alignment.TopCenter)
//                .clip(CircleShape)
//
//        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 100.dp),
        ) {
            Text(
                text = "Fit \nFeels \nGreet",
                style = MaterialTheme.typography.headlineLarge
                    .copy(
                        fontSize = 60.sp,
                        lineHeight = 80.sp,
                        fontWeight = FontWeight.Bold
                    ),
                color = Color.White,
                textAlign = TextAlign.Center
            )

        }



    }

}