package com.app.fitgo.presentation.explore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.data.test_data.Workouts
import com.app.fitgo.domain.repository.TrainerRepository
import com.app.fitgo.domain.repository.UserRepository
import com.app.fitgo.presentation.home.HomeUiState
import com.app.fitgo.presentation.trainer.TrainerEvent
import com.app.fitgo.presentation.trainer.TrainerState
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
class ExploreViewModel @Inject constructor(
    private val repository: UserRepository,
    private val trainerRepository: TrainerRepository,

    ):ViewModel() {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState = _uiState
        .onStart {
            getTrainers()
            getChallenges()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _uiState.value
        )

    private val _state = MutableStateFlow(ExploreState())
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

    fun onEvent(event: ExploreEvent){
        when(event){
            is ExploreEvent.EnterSearch -> {
                _state.update { it.copy(
                    search = event.search
                ) }
                _uiState.update { it.copy(
                    trainers = _uiState.value.previousTrainers.filter { it.name.contains(_state.value.search,ignoreCase = true)}
                )}
            }
            is ExploreEvent.Search -> {
                _uiState.update { it.copy(
                    trainers = _uiState.value.previousTrainers.filter { it.name.contains(_state.value.search,ignoreCase = true)}
                )}
            }
            is ExploreEvent.Favorite -> {

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
                            _uiState.update { it.copy(
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


    private fun getChallenges(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(1500L)
                _uiState.update { it.copy(
                    isLoading = false,
                    challenges = Workouts.challengeList,
                    shortWorkoutList = Workouts.workoutList
                ) }

            }catch (e: Exception){

            }
        }
    }
}