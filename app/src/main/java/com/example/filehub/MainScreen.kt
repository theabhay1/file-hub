package com.example.filehub

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.filehub.Navigation.NavGraph
import com.example.filehub.ui.component.AppBottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController)
        }
    ) { innerPadding ->
        NavGraph(innerPadding, navController)
    }
}