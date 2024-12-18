package com.app.fitgo.presentation.setting

sealed interface SettingEvent{
    data object ShowDeleteDialog: SettingEvent
    data object HideDeleteDialog: SettingEvent
    data object BackPress: SettingEvent
    data object LogOut: SettingEvent
}