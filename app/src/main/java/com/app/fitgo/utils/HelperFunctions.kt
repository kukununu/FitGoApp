package com.app.fitgo.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.SharedFlow


@Composable
fun HandleUiEvents(
    uiEvent: SharedFlow<String>, // Event flow from ViewModel
    context: Context
) {
    LaunchedEffect(uiEvent) {
        uiEvent.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}

