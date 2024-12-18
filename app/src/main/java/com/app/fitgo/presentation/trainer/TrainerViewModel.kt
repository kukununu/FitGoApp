package com.app.fitgo.presentation.trainer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.domain.repository.TrainerRepository
import com.app.fitgo.domain.repository.UserRepository
import com.app.fitgo.presentation.follower.FollowerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrainerViewModel @Inject constructor(
    private val repository: UserRepository,
    private val trainerRepository: TrainerRepository,
):ViewModel() {

    private val _uiState = MutableStateFlow(TrainerUiState())
    val uiState = _uiState
        .onStart {
            getTrainers()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private val _followerUiState = MutableStateFlow(FollowerUiState())
    val followerUiState = _followerUiState
        .onStart {
            getFollowerList()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _followerUiState.value
        )

    private val _state = MutableStateFlow(TrainerState())
    val state = _state

    private val _uiEvent = MutableSharedFlow<String>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun showToast(message: String) {
        viewModelScope.launch {
            _uiEvent.emit(message)
        }
    }

    private fun getTrainers(){
        viewModelScope.launch(Dispatchers.IO) {
            delay(1500L)
            val followers = repository.getUsers()[0].followers
            trainerRepository.getTrainers()
                .onEach { trainer ->
                    val trainerList = trainer.map { trainer ->
                        trainer.copy(isFollowed =  followers.contains(trainer.id))
                    }
                    _uiState.update { it.copy(
                        isLoading = false,
                        trainers = trainerList,
                        previousTrainers = trainerList
                    ) }

                }.launchIn(viewModelScope)

        }
    }

    fun onEvent(event: TrainerEvent){
        when(event){
            is TrainerEvent.EnterSearch -> {
                _state.update { it.copy(
                    search = event.search
                ) }
                _uiState.update { it.copy(
                    trainers = _uiState.value.previousTrainers.filter { it.name.contains(_state.value.search,ignoreCase = true)}
                )}
            }
            is TrainerEvent.Search -> {
                _uiState.update { it.copy(
                    trainers = _uiState.value.previousTrainers.filter { it.name.contains(_state.value.search,ignoreCase = true)}
                )}
            }
            is TrainerEvent.Favorite -> {

                addFavorite(event.id)
            }
            else -> Unit
        }
    }

    fun getFollowerList(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = repository.getUsers()
                if (user.isNotEmpty()){
                    val followers = user[0].followers
                    trainerRepository.getTrainers()
                        .onEach { trainer ->
                            val trainerList = trainer.map { trainer ->
                                trainer.copy(isFollowed =  followers.contains(trainer.id))
                            }.filter { it.isFollowed }
                            _followerUiState.update { it.copy(
                                isLoading = false,
                                trainers = trainerList,
                                previousTrainers = trainerList
                            ) }

                        }.launchIn(viewModelScope)
                }

            }catch (e: Exception){

            }
        }
    }


    private fun addFavorite(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var isAdded = false
                val users = repository.getUsers()
                if (users.isNotEmpty()) {
                    val user = users[0]
                    val updatedFollowers = user.followers.toMutableList().apply {
                        if (contains(id)) {
                            isAdded = false
                            // If ID is already in the list, remove it
                            remove(id)
                        } else {
                            isAdded = true
                            // If ID is not in the list, add it
                            add(id)
                        }
                    }

                    // Create updated user data with the modified followers list
                    val updatedUserData = user.copy(followers = updatedFollowers)

                    // Update the user data in the repository (e.g., Room database)
                    repository.updateUserData(updatedUserData)

                    getTrainers()
                    // Optionally, show a message to the user
                    val action = if (isAdded) "Followed" else "Unfollowed"
                    showToast("You have $action the trainer.")

                }
            }catch (e: Exception){

            }
        }
    }



}