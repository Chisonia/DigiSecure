package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.HeadingFour
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HeadingFour(value = "DigiSecure") },
                colors = topAppBarColors(
                    containerColor = PrimaryGreenNormal,
                    titleContentColor = PrimaryHoverLight,
                    actionIconContentColor = PrimaryHoverLight
                ),
                actions = {

                        Icon(
                            painter = painterResource(id = com.google.android.material.R.drawable.notification_bg),
                            contentDescription = "Close",
                            tint = Color.Cyan
                    )
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues),
            ){
                Image(
                    painter = painterResource(id = R.drawable.home_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize(),
                    alpha = 1F
                )
            }
        }
    )
}