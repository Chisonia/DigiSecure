package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.BodySmallSemiBold
import com.techdetect.digisecure.app_components.HeadingFour
import com.techdetect.digisecure.app_components.HeadingTwo
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HeadingTwo("Secure Your Gadgets") },
                colors = topAppBarColors(
                    containerColor = PrimaryHoverLight,
                    actionIconContentColor = PrimaryHoverDark
                ),
                actions = {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.HeadsetMic,
                            contentDescription = "Notifications"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
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
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryHoverLight,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BodyLargeRegularLight(value = "Register Device")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryHoverLight,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BodyLargeRegularLight(value = "Find my Device")
                }
            }
        },
        bottomBar = {
            NavigationBar (
                containerColor = PrimaryHoverLight,
                contentColor = PrimaryHoverDark
            ){
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        BodySmallSemiBold(value = "Home")
                    },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    },
                    label = {
                        BodySmallSemiBold(value = "Account")
                    },
                    selected = false,
                    onClick = {navController.navigate(Routes.AccountScreenRoute)}
                )
            }
        }
    )
}