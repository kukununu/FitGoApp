package com.app.fitgo.presentation.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.app.fitgo.data.test_data.TestingData
import com.app.fitgo.domain.model.TrainerData

@Composable
fun TrainerLazyRow(
    trainers: List<TrainerData>,
    onFollow: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(trainers, key = {it.id}){
            TrainerItem(it,onFollow)
        }
    }

}