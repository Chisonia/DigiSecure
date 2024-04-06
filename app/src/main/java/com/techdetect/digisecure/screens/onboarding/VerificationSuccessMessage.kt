package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.poppinsFontFamily
import com.techdetect.digisecure.ui.theme.DefaultColor
import com.techdetect.digisecure.ui.theme.SecondaryBlue1HoverLight
import com.techdetect.digisecure.ui.theme.TextColor

@Composable
fun VerificationSuccessMessage(){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = SecondaryBlue1HoverLight
    ){
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
           Text(
               text = "You have successfully verified",
               modifier = Modifier
                   .fillMaxWidth(),
               color = TextColor,
               textAlign = TextAlign.Center,
               fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium,
               style = TextStyle(
                   fontSize = 18.sp,
               )
           )
       }
    }
}