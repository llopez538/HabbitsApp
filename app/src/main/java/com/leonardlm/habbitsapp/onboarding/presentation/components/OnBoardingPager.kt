package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leonardlm.habbitsapp.core.presentation.components.atoms.HabitButton
import com.leonardlm.habbitsapp.onboarding.presentation.models.OnBoardingPagerInformation
import kotlinx.coroutines.launch

@Composable
fun OnBoardingPager(
    pages: List<OnBoardingPagerInformation>,
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
        ) { index ->
            val pageInfo = pages[index]
            PagePaginateScreen(
                title = pageInfo.title,
                subtitle = pageInfo.subtitle,
                image = pageInfo.image
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (pagerState.currentPage == pages.lastIndex) {
                HabitButton(
                    text = "Get Started",
                    modifier = Modifier.fillMaxWidth(),
                    onFinish = onFinish
                )
            } else {
                TextButton(
                    onClick = onFinish
                ) {
                    Text(
                        text = "Skip",
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                )
                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                ) {
                    Text(
                        text = "Next",
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                }
            }
        }
    }
}
