package com.app.fitgo.presentation.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.data.test_data.TestingData
import com.app.fitgo.domain.model.TrainerData
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey2

@Composable
fun TrainerItem(
    trainerData: TrainerData,
    onFollow: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .width(120.dp)
    ){
        Column { 
            TrainerImageBox(trainerData,onFollow)
            HorizontalSpacer()
            Text(
                text = trainerData.name,
                style = MaterialTheme.typography.labelLarge
                    .copy(
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )

            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(5){
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = null,
                        tint = if(trainerData.rating > it) Color(0XFFF2AF1E)  else  Grey2
                    )
                }
                HorizontalSpacer(4.dp)
                Text(
                    text = "${trainerData.rating}",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}


@Composable
fun TrainerImageBox(
    trainerData: TrainerData,
    onFollow: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
    ){
        AsyncImage(
            trainerData.profileImg,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),

            )
        Box(
            modifier = Modifier
                .clickable { onFollow(trainerData.id) }
                .padding(top = 8.dp, end = 8.dp)
                .size(32.dp)
                .background(BackgroundGrey1, CircleShape)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = if(trainerData.isFollowed) Color(0XFFDD3131) else Grey2
            )
        }
    }
}


@Preview
@Composable
private fun TrainerImageBoxPreview() {
    FitGoTheme {
        TrainerImageBox(TestingData.trainerList.first(), onFollow = {})
    }
}