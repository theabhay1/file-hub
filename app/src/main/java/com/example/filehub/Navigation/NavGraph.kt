package com.example.filehub.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filehub.ui.screens.cloud.CloudScreen
import com.example.filehub.ui.screens.files.FileScreen
import com.example.filehub.ui.screens.home.HomeScreen

@Composable
fun NavGraph(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home"){
            HomeScreen(paddingValues)
        }
        composable(route = "files"){
            FileScreen(paddingValues)
        }
        composable(route = "cloud"){
            CloudScreen(paddingValues)
        }
    }
}