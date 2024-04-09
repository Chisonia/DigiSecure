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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallMedium
import com.techdetect.digisecure.app_components.CaptionOne
import com.techdetect.digisecure.app_components.CaptionTwo
import com.techdetect.digisecure.app_components.ForgotPassword
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
fun SignInScreen(navController: NavHostController) {
    var password by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var areFieldsFilled by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var inputErrorMessage by remember { mutableStateOf("") }
    var passwordVisibilty by remember { mutableStateOf(false) }

    var icon = if (passwordVisibilty)
        painterResource(id = R.drawable.visibility)
    else
        painterResource(id = R.drawable.visibilityoff)


    fun areFieldsEmpty(): String {
        return when {
            userEmail.isEmpty() -> "Email address is required"
            password.isEmpty() -> "Password is required"
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
        HeadingThree(value = "Welcome Back!")
        SmallSpacer
        BodySmallMedium(value = "Please sign into your account")
        LargeSpacer
        OutlinedTextField(
            value = userEmail,
            onValueChange = {
                userEmail = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder= { BodyMediumMedium(value = "Email Address") },
            singleLine = true,
            shape = componentShape.large,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryGreenLight,
                unfocusedBorderColor = PrimaryGreenLight,
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
                errorMessage = validatePassword(it)
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Password") },
            singleLine = true,
            trailingIcon = {
                           IconButton(onClick = { passwordVisibilty = !passwordVisibilty })
                           {
                               Image(
                                   painter = icon, contentDescription = "Visibility", modifier = Modifier.size(24.dp))
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
                focusedBorderColor = PrimaryGreenLight,
                unfocusedBorderColor = PrimaryGreenLight,
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
        Row (
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ){
            TextButton(
                onClick = {navController.navigate(Routes.PasswordRecoveryRoute)},
                modifier = Modifier
                    .padding(bottom = 20.dp)

            ) {
                BodySmallMedium(value = "Forgot Password?")

            }
        }

        if (inputErrorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        LargeSpacer
        Button(
            onClick = {},
            enabled = areFieldsFilled,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryHoverNormal,
                contentColor = Color.White,
                disabledContainerColor = TransparentColor,
                disabledContentColor = Color.White

            ),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            BodyLargeRegular(value = "Sign In")
        }
        LargestSpacer
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CaptionTwo(value = "Don't Have An Account?")
            TextButton(
                onClick = {navController.navigate(Routes.DecisionRoute)}
            ) {
                CaptionOne(value = "Sign Up")
            }
        }
    }
}

fun validatePassword(password: String): String {
    // Your password validation logic here
    return "" // Return error message if validation fails
}