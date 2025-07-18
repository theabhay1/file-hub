package com.example.filehub.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.compose.ui.text.font.FontVariation

fun hasStoragePermission(context: Context): Boolean {
    return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
        Environment.isExternalStorageManager()
    }
    else{
        false
    }
}

fun requestStoragePermission(context: Context) {
    try{
        val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
        intent.data = Uri.parse("package:${context.packageName}")
        context.startActivity(intent)
    }catch (e: Exception){
        val intent = Intent()
        intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
        context.startActivity(intent)
    }
}