package com.app.fitgo.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.app.fitgo.R
import com.app.fitgo.domain.model.UserData

@Composable
fun ProfileCard(
    userData: UserData
) {

    val painter = rememberAsyncImagePainter(
        model = userData.profileImg,
        onSuccess = {
            Result.success(it.painter)
        },
        onError = {
            it.result.throwable.printStackTrace()
        }
    )

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(userData.profileImg)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = userData.userName,
            style = MaterialTheme.typography.titleSmall
                .copy(
                    Color.White
                )
        )
        Text(
            text = "Kazakhstan,Almaty",
            style = MaterialTheme.typography.labelLarge
                .copy(
                    Color(0XFF676161)
                )
        )
    }

}

@Composable
fun TabScreen() {

}