package com.app.fitgo.presentation.setting

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.Constants
import com.app.fitgo.data_store.DataStoreManager
import com.app.fitgo.domain.model.UserData
import com.app.fitgo.domain.repository.UserRepository
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.EventBus.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repository: UserRepository,
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _uiEvent.emit(message)
        }
    }

    fun onEvent(event: SettingEvent){
        when(event){
            is SettingEvent.ShowDeleteDialog -> {
                _state.update { it.copy(showLogoutDialog = true) }
            }
            is SettingEvent.HideDeleteDialog -> {
                _state.update { it.copy(showLogoutDialog = false) }
            }
            is SettingEvent.LogOut -> {

                logout(Constants.userData.id)
            }
            else -> Unit
        }
    }


    fun logout(id: String){
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.deleteById(id)
                dataStoreManager.setValue(Constants.USER_ID,UserData())
                delay(1500L)
                _state.update { it.copy(isLoading = false, showLogoutDialog = false) }
                showToast("Logout Successfully")
                sendEvent(Event.NavigateToLogin)
            }catch (e: Exception){
                _state.update { it.copy(isLoading = false) }
                Log.d("data","errpr ${e.message}")
                showToast("Something went wrong try again")
            }
        }
    }
}