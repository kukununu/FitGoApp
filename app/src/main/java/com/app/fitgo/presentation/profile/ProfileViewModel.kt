package com.app.fitgo.presentation.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState
        .onStart {
            getProfile()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private fun getProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user =   repository.getUsers()
                if (user.isNotEmpty()){
                    Log.d("data","user $user")
                    _uiState.update { it.copy(isLoading = false, user = user[0]) }
                }

            }catch (e: Exception){
                Log.d("data","error ${e.message}")
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }

        }
    }
}