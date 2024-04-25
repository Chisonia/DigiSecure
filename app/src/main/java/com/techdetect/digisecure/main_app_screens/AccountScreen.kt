package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.HeadingFourDark
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.view_models.AuthViewModel
import com.techdetect.digisecure.ui.theme.DarkButtonColor
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(navController: NavController, userName: String, authViewModel: AuthViewModel)  {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { HeadingThree(value = "User Account") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryHoverLight,
                    actionIconContentColor = Color.White
                )
            )
        },
        content = {paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 48.dp))
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                LargeSpacer
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(PrimaryHoverLight),
                    contentAlignment = Alignment.Center
                ) {
                        // Placeholder image when profile picture is not available
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(80.dp),
                            tint = PrimaryHoverDark
                        )
                }
                SmallSpacer
                HeadingThree(value = userName)
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(bottom = 20.dp)

                ) {
                    HeadingFourDark(value = "Update user account picture")

                }
                SmallSpacer
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    color = PrimaryHoverLight
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment  = Alignment.CenterVertically
                    ) {
                        BodyLargeRegular(value = "Manage Devices")
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = PrimaryHoverDark
                            )
                        }
                    }
                }
                SmallSpacer
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    color = PrimaryHoverLight
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment  = Alignment.CenterVertically
                    ) {
                        BodyLargeRegular(value = "Security Tips")
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = PrimaryHoverDark
                            )
                        }
                    }
                }
                SmallSpacer
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    color = PrimaryHoverLight
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment  = Alignment.CenterVertically
                    ) {
                        BodyLargeRegular(value = "Setting & Privacy ")
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "",
                                tint = PrimaryHoverDark
                            )
                        }
                    }
                }
                LargeSpacer
                Button(
                    onClick = { authViewModel.signOutUser()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkButtonColor,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    BodyLargeRegularLight(value = "Sign Out")
                }
            }
        }
    )
}
