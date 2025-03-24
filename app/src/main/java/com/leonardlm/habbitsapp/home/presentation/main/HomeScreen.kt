package com.leonardlm.habbitsapp.home.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
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
import androidx.compose.material3.TopAppBarDefaults
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
import com.leonardlm.habbitsapp.R
import com.leonardlm.habbitsapp.home.presentation.main.components.HomeQuote
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    /*Card {
                        Text("We first make our habits, \n" +
                                "and then our habits \n" +
                                "makes us."
                        )
                        Image(
                            painter = painterResource(R.drawable.onboarding1),
                            contentDescription = "Login background",
                            contentScale = ContentScale.FillWidth,
                        )
                    }*/

                    HomeQuote(text =
                        "We first make our habits, \n" +
                                "and then our habits \n" +
                                "makes us.",
                        author = "Anonymous",
                        imageId = R.drawable.onboarding1,
                        modifier = Modifier
                            .padding(16.dp)

                    )
                }
            }
        )
    }
}
