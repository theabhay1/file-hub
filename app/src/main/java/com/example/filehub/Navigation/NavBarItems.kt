package com.example.filehub.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavBarItem(
    val route: String,
    val title: String,
    val focusedIcon: ImageVector,
    val unfocusedIcon: ImageVector
){
    object home: NavBarItem("home", "Home", Icons.Filled.Home, Icons.Outlined.Home)
    object files: NavBarItem("files", "Files", Icons.Filled.Face, Icons.Outlined.Face)
    object cloud: NavBarItem("cloud", "Cloud", Icons.Filled.Star, Icons.Outlined.Star)
}