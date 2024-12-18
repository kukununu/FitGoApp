package com.app.fitgo.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.app.fitgo.ui.theme.LightGreen


@Composable
fun DefaultLoadingState() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = LightGreen,
            strokeCap = StrokeCap.Butt,
            strokeWidth = 5.dp,
            modifier = Modifier
                .size(50.dp)
                .testTag("Loading")
        )
    }

}

@Composable
fun ButtonLoadingState() {
    CircularProgressIndicator(
        color = Color.White,
        strokeCap = StrokeCap.Butt,
        strokeWidth = 3.dp,
        modifier = Modifier
            .size(24.dp)
            .testTag("Loading")
    )

}