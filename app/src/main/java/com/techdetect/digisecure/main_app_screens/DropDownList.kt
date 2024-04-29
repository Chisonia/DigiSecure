package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.ui.theme.DarkButtonColor
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.view_models.AuthViewModel

@Composable
fun DropDropList(navController: NavController, userName: String, authViewModel: AuthViewModel){
    Column(
        modifier = Modifier
        .padding(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 48.dp))
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            color = PrimaryHoverLight
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
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
                verticalAlignment = Alignment.CenterVertically
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
                verticalAlignment = Alignment.CenterVertically
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
            onClick = { authViewModel.signOutUser() },
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

