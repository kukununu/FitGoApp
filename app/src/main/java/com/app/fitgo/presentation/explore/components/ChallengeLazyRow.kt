package com.app.fitgo.presentation.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.app.fitgo.domain.model.ChallengeData
import com.app.fitgo.domain.model.ShortWorkoutData

@Composable
fun ChallengeLazyRow(
    challenges: List<ChallengeData>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(challenges, key = { it.id } ){
            ChallengeItem(it)
        }
    }

}

@Composable
fun ShortWorkoutLazyRow(
    shortWorkouts: List<ShortWorkoutData>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(shortWorkouts, key = { it.id } ){
            ShorWorkoutItem(it)
        }
    }

}