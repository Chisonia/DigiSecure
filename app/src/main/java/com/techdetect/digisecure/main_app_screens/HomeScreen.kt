package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.BodySmallSemiBold
import com.techdetect.digisecure.app_components.HeadingFour
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.HeadingTwo
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.SecondaryBlue1HoverLight


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavController, userName: String){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HeadingFour("Hello, $userName") },
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
                    IconButton(
                        onClick = { navController.navigate(Routes.PushNotificationScreenRoute) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Surface (
                Modifier.padding(paddingValues)
            ){
                Image(
                    painter = painterResource(id = R.drawable.account_background1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize(),
                    alpha = 1F
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.register_image
                        ),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth(),
                        contentDescription = null,
                        alignment = Alignment.Center
                    )

                    LargeSpacer
                    Button(
                        onClick = {navController.navigate(Routes.RegisterDeviceScreenRoute)},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryHoverLight,
                            contentColor = Color.White,
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = ButtonDefaults.elevatedShape
                    ) {
                        BodyLargeRegular(value = "Register Device")
                    }

                    MediumSpacer
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryHoverLight,
                            contentColor = Color.White,
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = ButtonDefaults.elevatedShape,
                        elevation  = ButtonDefaults.buttonElevation()
                    ) {
                        BodyLargeRegular(value = "Find my Device")
                    }
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
                    colors  = NavigationBarItemDefaults.colors(SecondaryBlue1HoverLight),
                    selected = false,
                    onClick = {navController.navigate(Routes.AccountScreenRoute)}
                )
            }
        }
    )
}