package com.app.fitgo.presentation.notification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.data.test_data.notificationList
import com.app.fitgo.domain.model.NotificationData
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey2
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun NotificationItem(
    notificationData: NotificationData
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey1, RoundedCornerShape(12.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(1.dp, LightGreen, CircleShape)
                ){
                    AsyncImage(
                        notificationData.profileImg,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = notificationData.title,
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                color = Color.White
                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = notificationData.time,
                        style = MaterialTheme.typography.bodyMedium
                            .copy(
                                color = LightGreen
                            )
                    )
                }
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.close),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Grey2
                    )
                }
            }
        }
    }


}


@Preview
@Composable
private fun NotificationItemPreview() {
    FitGoTheme {
        NotificationItem(notificationList.first())
    }

}