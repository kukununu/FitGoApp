package com.app.fitgo.presentation.explore

sealed interface ExploreEvent{
    data class EnterSearch(val search: String): ExploreEvent
    data object Search: ExploreEvent
    data class Favorite(val id: String): ExploreEvent
    data object BackPress: ExploreEvent

}