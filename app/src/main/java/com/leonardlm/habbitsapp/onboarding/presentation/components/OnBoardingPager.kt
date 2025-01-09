package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonardlm.habbitsapp.R

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

    Box(modifier = modifier) {
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
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = subtitle,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        if (onFinish != null) {
            androidx.compose.material3.Button(onClick = onFinish) {
                Text("Finish")
            }
        }
    }
}
