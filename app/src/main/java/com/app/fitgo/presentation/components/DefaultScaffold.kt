package com.app.fitgo.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.fitgo.ui.theme.Background

@Composable
fun DefaultScaffold(
    topAppBar : @Composable () -> Unit,
    content : @Composable () -> Unit
) {

    Scaffold(
        topBar = topAppBar,
        containerColor = Background,

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }

    }
}

@Composable
fun DefaultScaffold(
    topAppBar : @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    content : @Composable () -> Unit
) {

    Scaffold(
        topBar = topAppBar,
        bottomBar = bottomBar,
        containerColor = Background,

        ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }

    }
}

@Composable
fun DefaultScaffoldFab(
    topAppBar : @Composable () -> Unit,
    fab: @Composable () -> Unit,
    content : @Composable () -> Unit
) {

    Scaffold(
        topBar = topAppBar,
        floatingActionButton = fab,
        containerColor = Background,
        // contentWindowInsets = WindowInsets(0,0,0,0)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }

    }
}

@Composable
fun DefaultScaffoldFabOnly(
    fab: @Composable () -> Unit,
    content : @Composable () -> Unit
) {

    Scaffold(
        floatingActionButton = fab,
        containerColor = Background,
        contentWindowInsets = WindowInsets(0,0,0,0)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }

    }
}