package com.leonardlm.habbitsapp.main.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.main.presentation.home.components.HomeDateSelector
import com.leonardlm.habbitsapp.main.presentation.home.components.HomeHabit
import com.leonardlm.habbitsapp.main.presentation.home.components.HomeQuote
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel<HomeViewModel>(),
    onHabitClick: () -> Unit = {}
) {
    val state = viewModel.state
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        Image(
            painter = painterResource(R.drawable.homebackground),
            contentDescription = "Login background",
            contentScale = ContentScale.FillWidth,
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    Snackbar {
                        // The Material spec recommends a maximum of 2 lines of text.
                        Text(data.visuals.message, maxLines = 2, overflow = TextOverflow.Ellipsis)
                    }
                }
            },
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Home", fontWeight = FontWeight.Bold)
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                            )
                        }
                    },
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        scope.launch {
                            val longMessage =
                                "Very very very very very very very very very very very very very " +
                                        "very very very very very very very very very very very very " +
                                        "very very very very very very very very very very long message"
                            snackbarHostState.showSnackbar(longMessage)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Add",

                    )
                }
            },
            content = { innerPadding ->
                LazyColumn (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentPadding = PaddingValues(bottom = 20.dp)

                ) {
                    item {
                        HomeQuote(text =
                            "We first make our habits, \n" +
                                    "and then our habits \n" +
                                    "makes us.",
                            author = "Anonymous",
                            imageId = R.drawable.onboarding1,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(
                                    bottom = 16.dp,
                                    top = 8.dp
                                )

                        )
                    }
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .padding(bottom = 12.dp)
                        ) {
                            Text(
                                text = "Habits".uppercase(),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.tertiary,
                                fontSize = 14.sp
                            )
                            HomeDateSelector(
                                selectedDate = state.selectedDate,
                                mainDate = state.currentDate,
                                onDateClick = {
                                    viewModel.onEvent(HomeEvent.ChangeDate(it))
                                }
                            )
                        }
                    }

                    items(state.habits) { habit ->
                        HomeHabit(
                            habit = habit,
                            selectedDate = state.selectedDate.toLocalDate(),
                            onCheckedChange = {
                                viewModel.onEvent(HomeEvent.CompletedHabit(habit))
                            },
                            onHabitClick = { onHabitClick() },
                            modifier = Modifier.padding(start = 16.dp)
                        )

                    }
                }
            }
        )
    }
}
