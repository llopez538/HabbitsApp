package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonardlm.habbitsapp.R
import kotlinx.coroutines.launch

@Composable
fun OnBoardingPager(
    pages: List<String>,
    modifier: Modifier = Modifier,
    onFinish: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        HorizontalPager(
            state = pagerState,
        ) { page ->
            when(page) {
                0 -> Screen(
                    title = "WELCOME TO Monumental habits",
                    subtitle = "Description 1",
                    image = R.drawable.onboarding1
                )
                1 -> Screen(
                    title = "CREATE NEW HABIT EASILY",
                    subtitle = "Description 2",
                    image = R.drawable.onboarding2
                )
                2 -> Screen(
                    title = "KEEP TRACK OF YOUR PROGRESS",
                    subtitle = "Description 3",
                    image = R.drawable.onboarding3,
                    onFinish = onFinish
                )
                3 -> Screen(
                    title = "JOIN A SUPPORTIVE COMMUNITY",
                    subtitle = "Description 3",
                    image = R.drawable.onboarding4,
                    onFinish = onFinish
                )

            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(
                onClick = onFinish
            ) {
                Text("Skip")
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
            )
            if (pagerState.currentPage == pages.lastIndex) {
                TextButton(
                    onClick = onFinish
                ) {
                    Text("Get Started")
                }
            } else {
                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun Screen(
    title: String,
    subtitle: String,
    image: Int,
    onFinish: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = title,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = subtitle,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    inactiveColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
    indicatorWidth: Dp = 8.dp,
    indicatorHeight: Dp = 8.dp,
    spacing: Dp = 4.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val indicatorCount = pagerState.pageCount
        val currentPage = pagerState.currentPage

        for (i in 0 until indicatorCount) {
            val color = if (i == currentPage) activeColor else inactiveColor
            val isCurrentPage = i == currentPage
            Surface(
                modifier = Modifier
                    .padding(spacing)
                    .size(
                        width = if (isCurrentPage) indicatorWidth * 2 else indicatorWidth,
                        height = indicatorHeight
                    ),
                shape = CircleShape,
                color = color
            ) {}
        }
    }
}
