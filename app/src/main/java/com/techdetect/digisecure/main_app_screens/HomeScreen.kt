package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
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
import com.techdetect.digisecure.app_components.BodyMediumRegular
import com.techdetect.digisecure.app_components.BodySmallSemiBold
import com.techdetect.digisecure.app_components.HeadingFour
import com.techdetect.digisecure.app_components.HeadingOne
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.HeadingTwo
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargerSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.MiniSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.SecondaryBlue1HoverLight


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavController, userName: String){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.new_logo),
                        contentDescription = null,
                        modifier = Modifier.size(36.dp)

                    )
                },
                colors = topAppBarColors(
                    containerColor = PrimaryHoverLight,
                    actionIconContentColor = PrimaryHoverDark
                ),
                actions = {
                    IconButton(
                        onClick = {navController.navigate(Routes.MenuPageRoute)},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
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
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(16.dp)
                ) {
                    LargerSpacer
                    HeadingTwo(value = "DigiSecure App-")
                    MiniSpacer
                    HeadingTwo(value = "Device Security &")
                    MiniSpacer
                    HeadingTwo(value = "Monitoring")
                    MiniSpacer
                    HeadingTwo(value = "Solutions")
                    MediumSpacer
                    BodySmallSemiBold(
                        value = "A leading intelligent device security" +
                                "providing businesses and consumers with" +
                                "cutting-edge device security capabilities")
                    LargeSpacer
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        color = PrimaryGreenNormal
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BodyMediumRegular(value = "Device Management")
                            IconButton(
                                onClick = { /*TODO*/ },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowCircleRight,
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "",
                                    tint = PrimaryHoverLight
                                )
                            }
                        }
                    }

                    SmallSpacer
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        color = PrimaryGreenNormal
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BodyMediumRegular(value = "Incident Response & Recovery")
                            IconButton(
                                onClick = { /*TODO*/ },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowCircleRight,
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "",
                                    tint = PrimaryHoverLight
                                )
                            }
                        }
                    }
                    SmallSpacer
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(30.dp),
                        color = PrimaryGreenNormal
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BodyMediumRegular(value = "Threat Intelligence")
                            IconButton(
                                onClick = { /*TODO*/ },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowCircleRight,
                                    modifier = Modifier.size(24.dp),
                                    contentDescription = "",
                                    tint = PrimaryHoverLight
                                )
                            }
                        }
                    }
                    MediumSpacer

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardDoubleArrowDown,
                            contentDescription = "",
                            tint = PrimaryHoverLight,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                }
            }
        },
    )
}