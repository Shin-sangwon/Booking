package com.ssafy.booking.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ssafy.booking.ui.AppNavItem
import com.ssafy.booking.ui.LocalNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String
) {
    val navController = LocalNavigation.current
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(0xFF00C68E)
        ),
        title = { Text(text = "$title", color = Color.White) },
        actions = {
            IconButton(onClick = {
                navController.navigate(AppNavItem.Setting.route) {
                    popUpTo("login") { inclusive = true }
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "메뉴",
                    tint = Color.White
                )
            }
        }
    )
}
