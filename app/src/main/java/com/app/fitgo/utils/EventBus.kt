package com.app.fitgo.utils

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object EventBus {

    private val _events = Channel<Any>()
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event : Event){
        _events.send(event)
    }


}

sealed interface Event{

    data object NavigateToMyPost : Event
    data object NavigateToHome : Event
    data object NavigateToLogin : Event

}