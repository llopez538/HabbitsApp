package com.leonardlm.habbitsapp.navigation.navigationBar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.leonardlm.habbitsapp.navigation.models.NavigationBarItems

@Composable
internal fun NavigationBarH(
    navController: NavController,
    navigationBarState: NavigationBarState = rememberNavigationBarState(navController)
) {
    NavigationBar(
        containerColor = Color(0xFFE6E9F2),
        modifier = Modifier
            .windowInsetsPadding(
                WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
            )
            .height(70.dp)
    ) {
        NavigationBarItems.items.forEach { item ->
            val isSelected = navigationBarState.isRouteSelected(item.route)
                .collectAsState(initial = false)

            NavigationBarItem(
                label = { Text(text = item.label) },
                selected = isSelected.value,
                onClick = { navigationBarState.openRoute(item.route) },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                },
                modifier = Modifier.padding(0.dp),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0XFF002376),
                    indicatorColor = Color.White
                )
            )
        }
    }
}