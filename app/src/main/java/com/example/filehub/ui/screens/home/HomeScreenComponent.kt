package com.example.filehub.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filehub.data.StorageInfo
import java.time.LocalTime

@Composable
fun StorageCircle(storageInfo: StorageInfo) {

    val strokeColor : Color = Color.Blue.copy(alpha = 0.40f)
    val strokeWidth = 33.dp
    val usedPercentage = if(storageInfo.total.toInt() > 0){ storageInfo.used * 100 / storageInfo.total } else 0
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(226.dp)
    ) {
        Canvas(modifier = Modifier.size(226.dp)) {
            drawCircle(
                color = Color.LightGray,
                style = Stroke(width = strokeWidth.toPx())
            )

            drawArc(
                color = strokeColor,
                startAngle = -90f,
                sweepAngle = (usedPercentage / 100f) * 360,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$usedPercentage%",
                color = strokeColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "used",
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}


fun getGreeting(): String {
    val hour = LocalTime.now().hour
    return when (hour) {
        in 5..11 -> "Good morning"
        in 12..16 -> "Good afternoon"
        in 17..20 -> "Good evening"
        else -> "Good night"
    }
}
