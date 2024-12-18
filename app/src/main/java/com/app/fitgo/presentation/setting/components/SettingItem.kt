package com.app.fitgo.presentation.setting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.fitgo.R
import com.app.fitgo.presentation.components.HorizontalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.LightGreen

@Composable
fun SettingItem(
    title: String,
    icon: Int,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(BackgroundGrey1, RoundedCornerShape(12.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = Color(0XFF676161)
            )
            HorizontalSpacer(8.dp)
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall
                    .copy(
                        color = Color.White
                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.fluent__arrow_right),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color(0XFF676161)
            )
        }

    }

}

@Composable
fun SettingNotificationItem(
    title: String,
    icon: Int
) {

    var isChecked by remember{ mutableStateOf(false)}

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundGrey1, RoundedCornerShape(12.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp),
                tint = Color(0XFF676161)
            )
            HorizontalSpacer(8.dp)
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall
                    .copy(
                        color = Color.White
                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                },
                colors = SwitchDefaults.colors(
                    checkedIconColor = LightGreen,
                    uncheckedIconColor = Color(0XFFD9D9D9),
                    uncheckedThumbColor = Color(0XFFD9D9D9),
                    checkedThumbColor = Color.White,
                    uncheckedBorderColor = Color.Transparent,
                    checkedBorderColor =  Color.Transparent,
                    uncheckedTrackColor = Color(0XFF676161),
                    checkedTrackColor = LightGreen

                )
            )
        }

    }

}