package com.app.fitgo.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.fitgo.Constants
import com.app.fitgo.data.test_data.TestingData
import com.app.fitgo.data_store.DataStoreManager
import com.app.fitgo.domain.repository.PostRepository
import com.app.fitgo.domain.repository.TrainerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PostRepository,
    private val trainerRepository: TrainerRepository,
    private val dataStoreManager: DataStoreManager
): ViewModel() {

    init {
        addPosts()
    }


    private fun addPosts(){
        viewModelScope.launch {
            val isAdded = dataStoreManager.getValue(Constants.POST_ID,false) as Boolean
            Log.d("data","isAdded$isAdded")
            if (!isAdded){
                repository.addPosts(
                    TestingData.samplePostDataLists
                )
                trainerRepository.addTrainers(TestingData.trainerList)
                dataStoreManager.setValue(Constants.POST_ID,true)
            }

        }
    }


}