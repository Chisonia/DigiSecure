package com.techdetect.digisecure.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.techdetect.digisecure.R
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallMedium
import com.techdetect.digisecure.app_components.BodySmallRegular
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargestSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.OldUser
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.componentShape
import com.techdetect.digisecure.ui.theme.PrimaryGreenLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TransparentColor
import com.techdetect.digisecure.ui.theme.WarningColor

@Composable
fun SignUpScreen() {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var areFieldsFilled by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var inputErrorMessage by remember { mutableStateOf("") }
    var passwordVisibilty by remember { mutableStateOf(false) }

    val icon = if (passwordVisibilty)
        painterResource(id = R.drawable.visibility)
    else
        painterResource(id = R.drawable.visibilityoff)


    fun areFieldsEmpty(): String {
        return when {
            userName.isEmpty() -> "Full name is required"
            userEmail.isEmpty() -> "Email address is required"
            password.isEmpty() -> "Password is required"
            confirmPassword.isEmpty() -> "Confirm password is required"
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 94.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        HeadingThree(value = "Create New Account")
        SmallSpacer
        BodySmallMedium(value = "Please fill in the form to continue")
        LargeSpacer
        OutlinedTextField(
            value = userName,
            onValueChange = {
                userName = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Full Name") },
            singleLine = true,
            shape = componentShape.large,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = WarningColor,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .clip(componentShape.large)
                .border(0.dp, Color.Transparent)
                .background(PrimaryGreenLight)
        )
        SmallSpacer
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
        SmallSpacer

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { passwordVisibilty = !passwordVisibilty })
                {
                    Image(
                        painter = icon,
                        contentDescription = "Visibility")
                }
            },
            visualTransformation = if (passwordVisibilty) VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            shape = componentShape.large,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = WarningColor,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(componentShape.large)
                .border(0.dp, Color.Transparent)
                .background(PrimaryGreenLight)
        )
        SmallSpacer
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
                if (password.isNotEmpty()) {
                    errorMessage = checkPasswords(password, it)
                } else {
                    errorMessage = ""
                }
            },
            shape = componentShape.large,
            placeholder = { BodyMediumMedium(value = "Confirm Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { passwordVisibilty = !passwordVisibilty })
                {
                    Image(
                        painter = icon,
                        contentDescription = "Visibility")
                }
            },
            visualTransformation = if (passwordVisibilty) VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = WarningColor,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(componentShape.large)
                .border(0.dp, Color.Transparent)
                .background(PrimaryGreenLight)
        )

        if (errorMessage.isNotEmpty()) {
            BodySmallRegular(value = errorMessage)
        }

        if (inputErrorMessage.isNotEmpty()) {
            BodySmallRegular(value = inputErrorMessage)
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
            BodyLargeRegular(value = "Sign Up")
        }
        MediumSpacer
        OldUser()
    }
}

fun checkPasswords(password: String, confirmPassword: String): String {
    return if (password != confirmPassword) {
        "Passwords do not match"
    } else {
        ""
    }
}