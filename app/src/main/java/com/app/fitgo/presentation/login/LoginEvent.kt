package com.app.fitgo.presentation.login

sealed interface LoginEvent {

    data object Login: LoginEvent

}