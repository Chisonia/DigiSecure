package com.techdetect.digisecure.screens.onboarding
import android.util.Log
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallMedium
import com.techdetect.digisecure.app_components.BodySmallRegular
import com.techdetect.digisecure.app_components.CaptionOne
import com.techdetect.digisecure.app_components.CaptionTwo
import com.techdetect.digisecure.app_components.ErrorBodySmallRegular
import com.techdetect.digisecure.app_components.HeadingThree
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.componentShape
import com.techdetect.digisecure.models.AuthViewModel
import com.techdetect.digisecure.ui.theme.PrimaryGreenLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
import com.techdetect.digisecure.ui.theme.TransparentColor
import com.techdetect.digisecure.ui.theme.WarningColor

@Composable
fun SignUpCompScreen(navController: NavHostController, authViewModel: AuthViewModel) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var officeRole by remember { mutableStateOf("") }
    var companyEmail by remember { mutableStateOf("") }
    var companyName by remember { mutableStateOf("") }
    var areFieldsFilled by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var inputErrorMessage by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visibility)
    else
        painterResource(id = R.drawable.visibilityoff)

    fun checkPasswordsMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    fun areFieldsEmpty(): String {
        return when {
            userName.isEmpty() -> "Full name is required"
            officeRole.isEmpty() -> "Office role is required"
            companyEmail.isEmpty() -> "Company email is required"
            companyName.isEmpty() -> "Company name is required"
            password.isEmpty() -> "Password is required"
            confirmPassword.isEmpty() -> "Confirm password is required"
            else -> ""
        }
    }

    fun isPasswordValid(password: String): Boolean {
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[ ,{}[<>():+]!@#$%^&*-]).{10,}$")
        return passwordRegex.matches(password)
    }

    Image(
        painter = painterResource(id = R.drawable.onboarding_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 1F
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {Row (horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()){
        IconButton(
            onClick = { navController.navigate(Routes.DecisionRoute) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "Back Button",
                modifier = Modifier.size(24.dp),
                tint = Color.Cyan
            )
        }
    }
        MediumSpacer
        HeadingThree(value = "Create New Account")
        SmallSpacer
        BodySmallMedium(value = "Please fill in the form to continue")
        MediumSpacer

        // Full Name TextField
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

        // Office Role TextField
        OutlinedTextField(
            value = officeRole,
            onValueChange = {
                officeRole = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Office Role") },
            singleLine = true,
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

        // Company Email TextField
        OutlinedTextField(
            value = companyEmail,
            onValueChange = {
                companyEmail = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Company's Email Address") },
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

        // Company Name TextField
        OutlinedTextField(
            value = companyName,
            onValueChange = {
                companyName = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
            },
            placeholder = { BodyMediumMedium(value = "Company's Name") },
            singleLine = true,
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

        // Password TextField
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty() && confirmPassword.isNotEmpty() // Validate only when confirmPassword is not empty
                errorMessage = if (!isPasswordValid(it)) "Password must have at least 10 characters, one uppercase letter, one number, and one symbol" else ""
            },
            placeholder = { BodyMediumMedium(value = "Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Image(painter = icon, contentDescription = "Visibility", modifier = Modifier.size(24.dp))
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

        // Confirm Password TextField
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                inputErrorMessage = areFieldsEmpty()
                areFieldsFilled = inputErrorMessage.isEmpty()
                errorMessage = if (!checkPasswordsMatch(password, it)) "Passwords do not match" else ""
            },
            placeholder = { BodyMediumMedium(value = "Confirm Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Image(painter = icon, contentDescription = "Visibility", modifier = Modifier.size(24.dp))
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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

        // Error Messages
        if (errorMessage.isNotEmpty()) {
            ErrorBodySmallRegular(value = errorMessage)
        }

        if (inputErrorMessage.isNotEmpty()) {
            ErrorBodySmallRegular(value = inputErrorMessage)
        }

        LargeSpacer

        // Sign Up Button
        Button(
            onClick = { authViewModel.registerCompUser(
                username = userName,
                password = password,
                email = companyEmail,
                navController = navController ,
            )},
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

        // Sign In Link
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CaptionTwo(value = "Have An Account?")
            TextButton(
                onClick = { navController.navigate(Routes.SignInRoute) },
            ) {
                CaptionOne(value = "Sign In")
            }
        }
    }
}
