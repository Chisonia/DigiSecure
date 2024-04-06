package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallMedium
import com.techdetect.digisecure.app_components.BodySmallRegular
import com.techdetect.digisecure.app_components.CaptionTwo
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargestSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.componentShape
import com.techdetect.digisecure.ui.theme.PrimaryGreenLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TransparentColor
import com.techdetect.digisecure.ui.theme.WarningColor

@Composable
fun PasswordRecoveryScreen() {
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
            .padding(top = 94.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ){
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
        Row (
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            CaptionTwo(value = "Remember Password Now?")
            TextButton(
                onClick = {},

            ) {
                CaptionTwo(value = "Go Back")

            }
        }

        if (inputErrorMessage.isNotEmpty()) {
            Text(
                text = inputErrorMessage,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        LargestSpacer
        Button(
            onClick = {},
            enabled = areFieldsFilled,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverNormal,
                contentColor = Color.White,
                disabledContainerColor = TransparentColor,
                disabledContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            BodyLargeRegular(value = "Send Code")
        }
        TextButton(
            onClick = {},
            modifier = Modifier
                .padding(bottom = 20.dp)

        ) {
            CaptionTwo(value = "Resend Code")

        }
    }
}