package com.app.fitgo.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fitgo.R
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.Grey2

@Composable
fun DefaultSearch(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    onValue: (String) -> Unit,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {

    TextField(
        value = value,
        onValueChange = onValue,
        placeholder = {
            Text(
                text = placeHolder,
                fontSize = 16.sp,
                color = Grey2
            )

        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "Search",
                tint = Grey2
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = BackgroundGrey1,
            unfocusedContainerColor = BackgroundGrey1,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White.copy(0.8f)
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        singleLine = true,
        modifier = modifier
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    )

}