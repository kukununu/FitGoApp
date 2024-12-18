package com.app.fitgo.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey1

@Composable
fun UserCard(
    title: String,
    text: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .clickable { onClick() }
            .width(120.dp)
            .background(BackgroundGrey1, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall
                    .copy(
                        Color.White
                    )
            )
            VerticalSpacer(4.dp)
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge
                    .copy(
                        Color.White
                    )
            )
        }

    }

}