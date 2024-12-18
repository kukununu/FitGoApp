package com.app.fitgo.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.Constants
import com.app.fitgo.R
import com.app.fitgo.data_store.DataStoreManager
import com.app.fitgo.domain.model.UserData
import com.app.fitgo.domain.repository.UserRepository
import com.app.fitgo.utils.Event
import com.app.fitgo.utils.EventBus.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val  repository: UserRepository,
    private val dataStoreManager: DataStoreManager
): ViewModel() {


    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _uiEvent.emit(message)
        }
    }

    fun onLoginEvent(event: LoginEvent){
        when(event){
            is LoginEvent.Login -> {
                login()
            }
        }
    }

    private fun login(){
        _state.update { it.copy(isLoading = true) }
         viewModelScope.launch {
             try {
                 val userData = UserData(
                     id = "User1",
                     userName = "Liam Carter",
                     profileImg = "https://images.unsplash.com/photo-1499996860823-5214fcc65f8f?q=80&w=1366&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                     followers = emptyList(),
                     posts = emptyList()
                 )
                 repository.insertUserData(
                     userData
                 )
                 dataStoreManager.setValue(Constants.USER_ID,userData)
                 _state.update { it.copy(isLoading = false) }
                 showToast("Login Successfully")
                 sendEvent(Event.NavigateToHome)
                 Log.d("login","coomple")

             }catch (e: Exception){
                 _state.update { it.copy(isLoading = false) }
                 Log.d("login","error ${e.message}")
             }
         }
    }


}