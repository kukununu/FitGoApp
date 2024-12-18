package com.app.fitgo.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

@OptIn(ExperimentalAnimationApi::class)
fun defaultEnterTransition(): EnterTransition {
    return scaleIn(
        initialScale = 0.8f,
        animationSpec = tween(300, easing = EaseInOut)
    ) + fadeIn(animationSpec = tween(300))
}

@OptIn(ExperimentalAnimationApi::class)
fun defaultExitTransition(): ExitTransition {
    return scaleOut(
        targetScale = 1.2f,
        animationSpec = tween(300, easing = EaseInOut)
    ) + fadeOut(animationSpec = tween(300))
}