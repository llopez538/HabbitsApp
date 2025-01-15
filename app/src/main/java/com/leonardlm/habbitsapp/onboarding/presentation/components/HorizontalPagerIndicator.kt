package com.leonardlm.habbitsapp.onboarding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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