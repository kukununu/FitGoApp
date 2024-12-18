package com.app.fitgo.presentation.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitgo.ui.theme.Grey2

@Composable
fun StickyHead(
    title: String,
    onSeeMore: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
                .copy(
                    color = Color.White
                )
        )
        TextButton(
            onClick = onSeeMore
        ) {
            Text(
                text = "See All",
                style = MaterialTheme.typography.titleMedium
                    .copy(
                        fontSize = 16.sp,
                        color = Grey2
                    )
            )
        }

    }

}