package com.leonardlm.habbitsapp.home.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeAskPermission(
    permission: String,
    modifier: Modifier = Modifier,
) {
    val permissionState = rememberPermissionState(permission)
    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }

}