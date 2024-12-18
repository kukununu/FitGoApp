package com.app.fitgo.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.app.fitgo.domain.model.UserData
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey1
import com.app.fitgo.ui.theme.Grey2
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun HomeTopAppBar(
    userData: UserData,
    onNotification: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .statusBarsPadding()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
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
                ){
                    AsyncImage(
                        userData.profileImg,
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
                        text = "Hello,${userData.userName}",
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                color = Color.White
                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Today, ${getToday()}",
                        style = MaterialTheme.typography.bodyMedium
                            .copy(
                                color = Grey1
                            )
                    )
                }
            }

            IconButton(
                onClick = onNotification
            ) {
                Icon(
                    painter = painterResource(R.drawable.notification),
                    contentDescription = "Notification",
                    tint = Grey2,
                    modifier = Modifier.size(24.dp)
                )
            }

        }
    }
}

fun getToday() : String{
    val dateFormat = SimpleDateFormat("dd MMM", Locale.getDefault())
    val currentDate = dateFormat.format(Date())
    return currentDate
}


@Preview
@Composable
private fun HomeTopAppBarPreview() {
    FitGoTheme {
        HomeTopAppBar(
            userData = UserData(),
            onNotification = {}
        )
    }

}