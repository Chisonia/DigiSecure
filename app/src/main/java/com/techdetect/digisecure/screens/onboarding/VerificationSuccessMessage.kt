package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyMediumMediumTextColor
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.SecondaryBlue1HoverLight

@Composable
fun VerificationSuccessMessage(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Content of VerificationSuccessMessage
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SecondaryBlue1HoverLight
        ) {
            Row (verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End){
                IconButton(
                    onClick = { navController.navigate(Routes.SignInRoute) },
                    modifier = Modifier
                        .padding(24.dp)

                ) {
                    Icon(
                        painter = painterResource(id = com.google.android.material.R.drawable.ic_m3_chip_close),
                        contentDescription = "Close",
                        tint = PrimaryGreenNormal
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.success_icon),
                    contentDescription = "Succesful",
                    modifier = Modifier.size(120.dp)
                )
                MediumSpacer
                BodyMediumMediumTextColor(
                    value = "You have successfully verified",
                )
            }
        }
    }
}