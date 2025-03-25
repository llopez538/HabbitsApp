package com.leonardlm.habbitsapp.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.datesGraph(
    navController: NavController
) {
    navigation<DateGraph>(
        startDestination = Date,
    ) {
        composable<Date> {
            DatesScreen(
                onCalendarClick = {
                    navController.navigate(Calendar)
                }
            )
        }
        composable<Calendar> {
            Text("Calendar")
        }

    }
}

@Composable
fun DatesScreen(
    onCalendarClick: () -> Unit = {}
) {
    Text("Dates")
    Button (onClick = { onCalendarClick () }) {
        Text("Go to Calendar")
    }
}
