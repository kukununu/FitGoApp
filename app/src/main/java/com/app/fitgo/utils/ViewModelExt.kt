package com.app.fitgo.utils

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//fun ViewModel.sendEvent(event : Any){
//    viewModelScope.launch {
//        EventBus.sendEvent(event)
//    }
//}

@Composable
fun ObserveLifecycleEvents(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onEvent: (Any) -> Unit
) {
    LaunchedEffect(key1 = lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            EventBus.events.collectLatest { event ->
                onEvent(event)
            }
        }
    }
}

