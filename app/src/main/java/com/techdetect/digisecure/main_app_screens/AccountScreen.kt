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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.horizontalMiniSpacer
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@Composable
fun AccountScreen(navController: NavController) {
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
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 128.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
        SmallSpacer
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverLight,
                contentColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.AccountCircle,
                contentDescription = "")
            horizontalMiniSpacer
            BodyLargeRegularLight(value = "My Account ")
        }
        SmallSpacer
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BodyLargeRegularLight(value = "Manage Devices")
                IconButton(onClick = { /*TODO*/ }) {
                    Icons.Default.ArrowDropDown
                }
            }
        }
    }
}