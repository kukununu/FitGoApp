package com.app.fitgo.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.fitgo.R
import com.app.fitgo.presentation.components.ButtonLoadingState
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.ui.theme.Background

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Image(
            painter = painterResource(R.drawable.o1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(Background.copy(0.2f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            VerticalSpacer()
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "LOGIN",
                style = MaterialTheme.typography.headlineSmall
                    .copy(fontWeight = FontWeight.Bold),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),

                )
            VerticalSpacer(12.dp)
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    onEvent(LoginEvent.Login)
//                    isLoading = true
//                    scope.launch {
//                        delay(1500L)
//                        isLoading = false
//                        onLogin()
//                    }

                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF2DA253)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {

                if(state.isLoading){
                    ButtonLoadingState()
                }else{
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.google),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        HorizontalSpacer()
                        Text(
                            text = "SIGN WITH GOOGLE",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                }


            }
            VerticalSpacer(98.dp)

        }
    }


}