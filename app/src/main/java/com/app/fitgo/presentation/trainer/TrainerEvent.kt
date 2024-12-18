package com.app.fitgo.presentation.trainer

sealed interface TrainerEvent{
    data class EnterSearch(val search: String): TrainerEvent
    data object Search: TrainerEvent
    data class Favorite(val id: String): TrainerEvent
    data object BackPress: TrainerEvent

}