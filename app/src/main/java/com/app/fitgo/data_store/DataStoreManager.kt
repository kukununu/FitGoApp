package com.app.fitgo.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.app.fitgo.domain.model.UserData
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

const val USER_DATA = "user_data"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATA)

class DataStoreManager (val context : Context){
    private val dataStore = context.dataStore

    suspend fun setValue(key : String,value: Any){
        dataStore.edit { preferences ->
            when(value){
                is UserData -> {
                    val userDataJson = Json.encodeToString(value)
                    preferences[stringPreferencesKey(key)] = userDataJson
                }
                is Int -> {
                    preferences[intPreferencesKey(key)] = value
                }
                is Boolean -> {
                    preferences[booleanPreferencesKey(key)] = value
                }
                else -> throw IllegalArgumentException("Unsupported value type")
            }
        }
    }

    suspend fun getValue(key: String, defaultValue : Any) : Any {
        val preferences = dataStore.data.first()
        when(defaultValue){
            is UserData -> {
                val userDataJson = preferences[stringPreferencesKey(key)] ?: return defaultValue
                return Json.decodeFromString<UserData>(userDataJson)
            }
            is Int -> {
                return preferences[intPreferencesKey(key)] ?: defaultValue
            }
            is Boolean -> {
                return preferences[booleanPreferencesKey(key)] ?: defaultValue
            }

            else -> throw IllegalArgumentException("Unsupported value type")
        }

    }
}