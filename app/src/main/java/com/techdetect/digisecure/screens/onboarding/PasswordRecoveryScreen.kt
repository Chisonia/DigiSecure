package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallMedium
import com.techdetect.digisecure.app_components.CaptionTwo
import com.techdetect.digisecure.app_components.ErrorBodySmallRegular
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargestSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.componentShape
import com.techdetect.digisecure.models.AuthViewModel
import com.techdetect.digisecure.ui.theme.PrimaryGreenLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TransparentColor
import com.techdetect.digisecure.ui.theme.WarningColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRecoveryScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    var userEmail by remember { mutableStateOf("") }
    var inputErrorMessage by remember { mutableStateOf("") }
    var areFieldsFilled by remember { mutableStateOf(false) }


    fun areFieldsEmpty(): String {
        return when {
            userEmail.isEmpty() -> "Email address is required"
            else -> ""
        }
    }
    Image(
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize(),
        alpha = 1F
    )
    Column (
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(top = 64.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ){
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = {
                    navController.navigate(Routes.SignInRoute)
                }
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "Back Button",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Cyan
                )
            }
        }
        MediumSpacer
        HeadingThree(value = "Password Recovery")
        SmallSpacer
        BodySmallMedium(value = "Enter the email address you used for registration.")
        LargeSpacer
        OutlinedTextField(
            value = userEmail,
            onValueChange = {
                userEmail = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Email Address") },
            singleLine = true,
            shape = componentShape.large,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = WarningColor,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .clip(componentShape.large)
                .border(0.dp, Color.Transparent)
                .background(PrimaryGreenLight)
        )

        if (inputErrorMessage.isNotEmpty()) {
            ErrorBodySmallRegular(value = inputErrorMessage)
        }
        LargestSpacer
        Button(
            onClick = {authViewModel.resetPassword(email = userEmail, navController = navController)},
            enabled = areFieldsFilled,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverNormal,
                contentColor = Color.White,
                disabledContainerColor = TransparentColor,
                disabledContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            BodyLargeRegular(value = "Send Reset Link")
        }
    }
}