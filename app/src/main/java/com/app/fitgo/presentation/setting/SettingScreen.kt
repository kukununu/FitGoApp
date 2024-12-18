package com.app.fitgo.presentation.setting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitgo.Constants
import com.app.fitgo.R
import com.app.fitgo.presentation.components.ButtonLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.presentation.profile.components.ProfileCard
import com.app.fitgo.presentation.setting.components.EditProfileCard
import com.app.fitgo.presentation.setting.components.SettingItem
import com.app.fitgo.presentation.setting.components.SettingNotificationItem
import com.app.fitgo.ui.theme.BackgroundGrey
import com.app.fitgo.ui.theme.Green
import com.app.fitgo.ui.theme.Grey2

@Composable
fun SettingScreen(
    state: SettingState,
    onEvent: (SettingEvent) -> Unit
) {


    if (state.showLogoutDialog){
        LogoutDialog(
            state.isLoading,
            onDismiss = {
                onEvent(SettingEvent.HideDeleteDialog)
            },
            onConfirm = {
                onEvent(SettingEvent.LogOut)
            }
        )
    }


    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                "Setting",
                onBackPress = {
                    onEvent(SettingEvent.BackPress)
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditProfileCard()
            VerticalSpacer()
            VerticalSpacer()
            SettingNotificationItem(
                title = "Notification",
                icon = R.drawable.notify
            )
            VerticalSpacer()
            SettingItem(
                title = "Edit Profile",
                icon = R.drawable.fluent_person_28_filled,
                onClick = {}
            )
            VerticalSpacer()
            SettingItem(
                title = "Privacy Policy",
                icon = R.drawable.privacy_policy,
                onClick = {}
            )
            VerticalSpacer()
            SettingItem(
                title = "Terms & Conditions",
                icon = R.drawable.terms,
                onClick = {}
            )
            VerticalSpacer()
            SettingItem(
                title = "Logout",
                icon = R.drawable.phone,
                onClick = {
                    onEvent(SettingEvent.ShowDeleteDialog)
                }
            )
            VerticalSpacer()
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Delete Account",
                    style = MaterialTheme.typography.labelMedium
                        .copy(
                            color = Color.White,
                            textDecoration = TextDecoration.Underline
                        )
                )
            }

        }
    }

}


@Composable
fun LogoutDialog(
    isLoading : Boolean,
    onConfirm : () -> Unit,
    onDismiss : () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, Green),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "CANCEL",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Grey2
                    )

                }
                Button(
                    onClick = onConfirm,
                    modifier = Modifier
                        .width(150.dp)
                        .height(42.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    if(isLoading){
                        ButtonLoadingState()

                    }else{
                        Text(
                            text = "CONFIRM",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }


                }

            }

        },
        title = {
            Text(
                text = "Logout",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        text = {
            Text(
                text = "Are sure you want to logout",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Grey2
            )
        },
        shape = RoundedCornerShape(16.dp),
        containerColor = BackgroundGrey
    )

}
