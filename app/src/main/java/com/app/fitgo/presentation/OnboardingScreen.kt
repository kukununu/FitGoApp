package com.app.fitgo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.fitgo.R
import com.app.fitgo.presentation.components.VerticalSpacer
import com.app.fitgo.ui.theme.Background
import com.app.fitgo.ui.theme.LightGreen
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.sign

data class OnboardingData(
    val id: String = "",
    val content: String = "",
    val image: Int = 0
)

val onboardingList = listOf(
    OnboardingData(
        "1",
        "Your journey to a healthier \nyou starts here.",
        R.drawable.onboarding1
    ),
    OnboardingData(
        "2",
        "Fitness is a lifestyle. \nStart logging in!",
        R.drawable.onboarding2
    ),
    OnboardingData(
        "3",
        "Make today the day you \ncommit to your health",
        R.drawable.o1
    )
)

@Composable
fun OnboardingScreen(
    onNavigateToLogin: () -> Unit
) {

    val pagerState = rememberPagerState { onboardingList.size }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background.copy(0.5f))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VerticalSpacer(50.dp)
                HorizontalPagerIndicator(
                    modifier = Modifier
                        .statusBarsPadding(),
                    pagerState = pagerState,
                    pageCount = 3,
                    indicatorWidth = 60.dp,
                    indicatorHeight = 8.dp,
                    spacing = 30.dp,
                    indicatorShape = RoundedCornerShape(4.dp)
                )
                HorizontalPager(
                    modifier = Modifier.weight(1f),
                    state = pagerState,
                    pageSpacing = 16.dp
                ) { page ->

                    val onboardData = onboardingList[page]
                    Box(modifier = Modifier.fillMaxSize()){
                        AsyncImage(
                            onboardData.image,
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
                                .padding(16.dp)
                                .background(Background.copy(0.5f)),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = onboardData.content,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                            VerticalSpacer(12.dp)
                            Button(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(48.dp),
                                onClick = {
                                    scope.launch {
                                        if (pagerState.currentPage == 2){
                                            onNavigateToLogin()
                                        }else{
                                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                        }
                                    }

                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0XFF2DA253)
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = if(pagerState.currentPage == 2) "Let's Begin" else "NEXT",
                                    style = MaterialTheme.typography.titleMedium
                                        .copy(fontSize = 20.sp),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,

                                    )
                            }
                            VerticalSpacer(20.dp)

                        }
                    }


                }

                VerticalSpacer(30.dp)
            }
        }
    }
}





@Composable
private fun HorizontalPagerIndicator(
    pagerState: PagerState,
    pageCount: Int,
    modifier: Modifier = Modifier,
    pageIndexMapping: (Int) -> Int = { it },
    activeColor: Color = LightGreen,
    inactiveColor: Color = Color.White,
    indicatorWidth: Dp = 8.dp,
    indicatorHeight: Dp = indicatorWidth,
    spacing: Dp = indicatorWidth,
    indicatorShape: Shape = CircleShape,
) {

    val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
    val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val indicatorModifier = Modifier
                .size(width = indicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            repeat(pageCount) {
                Box(indicatorModifier)
            }
        }

        Box(
            Modifier
                .offset {
                    val position = pageIndexMapping(pagerState.currentPage)
                    val offset = pagerState.currentPageOffsetFraction
                    val next = pageIndexMapping(pagerState.currentPage + offset.sign.toInt())
                    val scrollPosition = ((next - position) * offset.absoluteValue + position)
                        .coerceIn(
                            0f,
                            (pageCount - 1)
                                .coerceAtLeast(0)
                                .toFloat()
                        )

                    IntOffset(
                        x = ((spacingPx + indicatorWidthPx) * scrollPosition).toInt(),
                        y = 0
                    )
                }
                .size(width = indicatorWidth, height = indicatorHeight)
                .then(
                    if (pageCount > 0) Modifier.background(
                        color = activeColor,
                        shape = indicatorShape,
                    )
                    else Modifier
                )
        )
    }
}
