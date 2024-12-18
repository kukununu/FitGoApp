package com.app.fitgo.presentation.create_post

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.presentation.components.ButtonLoadingState
import com.app.fitgo.presentation.components.DefaultScaffold
import com.app.fitgo.presentation.components.DefaultTopAppBar
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.ui.theme.BackgroundGrey
import com.app.fitgo.ui.theme.BackgroundGrey1
import com.app.fitgo.ui.theme.Grey2
import java.io.File

@Composable
fun CreatePostScreen(
    state: CreatePostState,
    onEvent: (CreatePostEvent) -> Unit,
    onNavigateToBack: () -> Unit
) {

    val context = LocalContext.current

    var tempPhotoUri by remember { mutableStateOf(value = Uri.EMPTY) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri: Uri? ->


            if (uri == null) return@rememberLauncherForActivityResult

            val input =
                context.contentResolver.openInputStream(uri)
                    ?: return@rememberLauncherForActivityResult
            val outputFile = context.filesDir.resolve("${System.currentTimeMillis()}.jpg")
            input.copyTo(outputFile.outputStream())
            onEvent(CreatePostEvent.EnterImage(outputFile.toString()))
        }

    DefaultScaffold(
        topAppBar = {
            DefaultTopAppBar(
                "Create Post",
                onBackPress = onNavigateToBack
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .clickable {
                        launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }
                    .fillMaxWidth()
                    .height(190.dp)
                    .background(BackgroundGrey1, RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ){
                if(state.image.isEmpty()){
                    Box(
                        modifier = Modifier
                            .width(170.dp)
                            .height(120.dp)
                            .background(BackgroundGrey, RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(R.drawable.gridicons_image),
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                            VerticalSpacer(4.dp)
                            Text(
                                text = "Upload",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        }

                    }
                }else{
                    AsyncImage(
                        state.image,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null
                    )
                }

            }
            VerticalSpacer()
            TextField(
                value = state.content,
                onValueChange = {
                    onEvent(CreatePostEvent.EnterContent(it))
                },
                placeholder = {
                    Text(
                        text = "Share your thoughts",
                        style = MaterialTheme.typography.bodyLarge
                            .copy(color = Grey2)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = BackgroundGrey1,
                    unfocusedContainerColor = BackgroundGrey1,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Grey2
                ),
                textStyle = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onEvent(CreatePostEvent.Upload)
                },
                modifier = Modifier
                    .width(300.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF2DA253)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                if (state.isLoading){
                    ButtonLoadingState()
                }else{
                    Text(
                        text = "UPLOAD",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
            VerticalSpacer()

        }
    }

}

fun Context.createTempPictureUri(
    provider: String = "${this.packageName}.provider",
    fileName: String = "picture_${System.currentTimeMillis()}",
    fileExtension: String = ".png"
): Uri {
    val tempFile = File.createTempFile(
        fileName, fileExtension, externalCacheDir
    ).apply {
        createNewFile()
    }

    return FileProvider.getUriForFile(applicationContext, provider, tempFile)
}