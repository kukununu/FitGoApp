package com.app.fitgo.presentation.trainer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.presentation.trainer.TrainerEvent
import com.app.fitgo.ui.theme.BackgroundGrey
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.FitGoTheme
import com.app.fitgo.ui.theme.Grey2
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun TrainerItem2(
    trainerData: TrainerData,
    onEvent: (TrainerEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey1, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                ){
                    AsyncImage(
                        trainerData.profileImg,
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                VerticalSpacer(4.dp)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(trainerData.rating){
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = if(trainerData.rating > it) Color(0XFFF2AF1E) else Grey2
                        )
                    }
                    HorizontalSpacer(8.dp)
                    Text(
                        text = "-(${trainerData.rating})",
                        style = MaterialTheme.typography.labelMedium
                            .copy(
                                color = Color.White
                            )
                    )
                }
            }
            HorizontalSpacer(8.dp)
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = trainerData.name,
                    style = MaterialTheme.typography.titleMedium
                        .copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                )
                VerticalSpacer(8.dp)
                Text(
                    text = trainerData.specialty,
                    style = MaterialTheme.typography.labelLarge
                        .copy(
                            color = Grey2,
                            fontWeight = FontWeight.Bold
                        )
                )
                VerticalSpacer(8.dp)
                Box(
                    modifier = Modifier
                      //  .padding(vertical = 8.dp, horizontal = 12.dp)
                        .background(Color.Transparent, RoundedCornerShape(100))
                        .border(1.dp, LightGreen, RoundedCornerShape(100)),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "${trainerData.experience} Years of experience",
                        style = MaterialTheme.typography.bodySmall
                            .copy(
                                color = LightGreen
                            ),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }



            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.fluent__arrow_right),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Grey2
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 8.dp, end = 8.dp)
                .size(38.dp)
                .background(BackgroundGrey, CircleShape)
                .align(Alignment.TopEnd)
                .clickable { onEvent(TrainerEvent.Favorite(trainerData.id)) },
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(R.drawable.heart),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if(trainerData.isFollowed) Color(0XFFDD3131) else Grey2
            )
        }
    }
}


@Preview
@Composable
private fun TrainerItem2Preview() {
    FitGoTheme {
        TrainerItem2(TestingData.trainerList.first(), onEvent = {})

    }

}