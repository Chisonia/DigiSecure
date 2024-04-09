package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.BodyMediumMediumLight
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@Composable
fun DecisionScreen(navController: NavHostController){
    Image(
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 1F
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 128.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
        LargeSpacer
        BodyMediumMediumLight(
            value = "Select your method of Sign in/Sign Up"
        )
        SmallSpacer
        Button(
            onClick = {navController.navigate(Routes.SignUpRoute)},
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverLight,
                contentColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BodyLargeRegularLight(value = "Personal Account ")
        }
        MediumSpacer
        Button(
            onClick = {navController.navigate(Routes.SignUpCompRoute)},
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverLight,
                contentColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BodyLargeRegularLight(value = "Company’s Account")
        }
    }
}