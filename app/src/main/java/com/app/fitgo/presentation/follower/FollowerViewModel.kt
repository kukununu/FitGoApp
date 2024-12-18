package com.app.fitgo.presentation.follower

import androidx.lifecycle.ViewModel
import com.app.fitgo.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FollowerViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel() {


}