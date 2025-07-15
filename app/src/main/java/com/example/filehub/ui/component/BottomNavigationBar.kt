package com.example.filehub.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.filehub.Navigation.NavBarItem

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        NavBarItem.home,
        NavBarItem.files,
        NavBarItem.cloud
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if(currentRoute != item.route){
                        navController.navigate(item.route){
                            popUpTo("home")
                            launchSingleTop = true
                        }
                    }

                },
                icon = {
                    if(currentRoute == item.route)
                        Icon(imageVector = item.focusedIcon, contentDescription = item.title)
                    else
                        Icon(imageVector = item.unfocusedIcon, contentDescription = item.title)
                },
                label = { Text(item.title) }

            )
        }
    }
}