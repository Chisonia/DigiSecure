package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.BodyLargeSemiBold
import com.techdetect.digisecure.app_components.CaptionOneBlack
import com.techdetect.digisecure.app_components.CaptionTwoBlack
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.poppinsFontFamily
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TextColor

@Composable
fun ResetSuccessMessage(navController: NavHostController) {


    Surface(
        color = Color.Black.copy(alpha = 0.5f), // Semi-transparent black overlay
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 16.dp) // Adjust padding here
                    .background(PrimaryHoverLight)
                    .padding(horizontal = 16.dp, vertical = 64.dp) // Adjust padding here
            ) {
                Image(
                    painter = painterResource(id = R.drawable.new_logo),
                    contentDescription = null,
                    modifier = Modifier.size(120.dp) // Adjust image size here
                )
                MediumSpacer
                BodyLargeSemiBold(value = "Check your email for password reset link")
                Text(
                    text = "Sign In with your new password. ",
                    color = TextColor,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
                MediumSpacer
                Button(
                    onClick = {navController.navigate(Routes.SignInRoute)},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryHoverNormal,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BodyLargeRegularLight(value = "Sign In")
                }
                SmallSpacer
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CaptionTwoBlack(value = "Didn't receive password reset link?")
                    TextButton(
                        onClick = { navController.navigate(Routes.SignInRoute) },
                    ) {
                        CaptionOneBlack(value = "Resend")
                    }
                }
            }
        }
    }
}