package com.app.fitgo.presentation.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.data.test_data.notificationList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotificationViewModel @Inject constructor():ViewModel() {

    private val _uiState = MutableStateFlow(NotificationUiState())
    val uiState = _uiState
        .onStart {
            getNotifications()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private fun getNotifications() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                delay(1500L)
                _uiState.update { it.copy(isLoading = false, notifications = notificationList) }

            }catch (e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}