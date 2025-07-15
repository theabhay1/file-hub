package com.example.filehub.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filehub.R

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    val userName = stringResource(R.string.user_name)
    val freeSpace: Int = 50
    val usedSpace: Int = 120
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = getGreeting(),
                    fontSize = 24.sp,
                    lineHeight = 45.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$userName👋",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            IconButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(40))
                    .background(Color.LightGray.copy(alpha = 0.4f))
                    .border(
                        BorderStroke(1.dp, color = Color.DarkGray),
                        shape = RoundedCornerShape(40)
                    )
                    .align(Alignment.CenterVertically),
                onClick = {
                    Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.TwoTone.Search, contentDescription = "Search")
            }
        }

        Spacer(Modifier.height(150.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column  {
                Text(
                    text = "$freeSpace GB",
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 20.sp
                )
                Text(
                    text = "Free"
                )
            }

            StorageCircle(freeSpace, usedSpace)

            Column(
                verticalArrangement = Arrangement.Bottom
            )  {
                Text(
                    text = "$usedSpace GB",
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 20.sp
                )
                Text(
                    text = "used"
                )
            }
        }

    }
}
