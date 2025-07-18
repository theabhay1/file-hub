package com.example.filehub

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.filehub.ui.screens.PermissionScreen
import com.example.filehub.ui.screens.home.HomeScreen
import com.example.filehub.ui.screens.home.StorageCircle
import com.example.filehub.ui.theme.FileHubTheme
import com.example.filehub.ui.theme.manrope
import com.example.filehub.util.hasStoragePermission
import com.example.filehub.util.requestStoragePermission

class MainActivity : ComponentActivity() {
    private var hasPermissionState by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FileHubTheme {
                if(hasPermissionState)
                    MainScreen()
                else
                    PermissionScreen(this)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        hasPermissionState = hasStoragePermission(this)
    }
}
