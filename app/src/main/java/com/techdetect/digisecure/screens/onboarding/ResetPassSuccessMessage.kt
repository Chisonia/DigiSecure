package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeSemiBold
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargestSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.poppinsFontFamily
import com.techdetect.digisecure.ui.theme.PrimaryGreenLightActive
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TextColor
import com.techdetect.digisecure.ui.theme.TransparentColor

@Composable
fun ResetSuccessMessage() {


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
                BodyLargeSemiBold(value = "Password successfully reset!")
                Text(
                    text = "You can now access your account with this new password. ",
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
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryHoverNormal,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BodyLargeRegular(value = "Sign In")
                }
            }
        }
    }
}