//package com.techdetect.digisecure.screens.onboarding
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Surface
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.techdetect.digisecure.AuthenticationManager.retrieveVerificationCode
//import com.techdetect.digisecure.AuthenticationManager.verifyUserCode
//import com.techdetect.digisecure.Routes
//import com.techdetect.digisecure.app_components.BodyLargeRegular
//import com.techdetect.digisecure.app_components.BodySmallRegular
//import com.techdetect.digisecure.app_components.DisplayTwo
//import com.techdetect.digisecure.app_components.ErrorBodySmallRegular
//import com.techdetect.digisecure.app_components.LargerSpacer
//import com.techdetect.digisecure.app_components.LargestSpacer
//import com.techdetect.digisecure.app_components.SmallSpacer
//import com.techdetect.digisecure.ui.theme.PrimaryHoverNormal
//import com.techdetect.digisecure.ui.theme.SecondaryBlue1LightActive
//import com.techdetect.digisecure.ui.theme.TransparentColor
//import kotlinx.coroutines.delay
//
//@Composable
//fun VerificationScreen(navController: NavHostController, email: String) {
//    var verificationCodeFirst by remember { mutableStateOf("") }
//    var verificationCodeSecond by remember { mutableStateOf("") }
//    var verificationCodeThird by remember { mutableStateOf("") }
//    var verificationCodeLast by remember { mutableStateOf("") }
//    var errorMessage by remember { mutableStateOf("") }
//
//    // Timeout logic
//    LaunchedEffect(key1 = true) {
//        delay(60 * 60 * 24 * 1000L) // 24 hours timeout
//        errorMessage = "Verification code expired. Please request a new one."
//        // Handle navigation or UI changes as needed
//    }
//
//    fun areFieldsEmpty(): Boolean {
//        return verificationCodeFirst.isEmpty() ||
//                verificationCodeSecond.isEmpty() ||
//                verificationCodeThird.isEmpty() ||
//                verificationCodeLast.isEmpty()
//    }
//
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = SecondaryBlue1LightActive
//    ) {
//        Column(
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier.padding(16.dp)
//        ) {
//            LargestSpacer
//            DisplayTwo(value = "VERIFICATION")
//            SmallSpacer
//            BodySmallRegular(value = "Verification code has been sent to your email, please check your email.")
//            LargestSpacer
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                TextField(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(end = 4.dp)
//                        .background(Color.Transparent),
//                    value = verificationCodeFirst,
//                    onValueChange = { verificationCodeFirst = it.filter { it.isDigit() }.take(1) },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                    colors = TextFieldDefaults.colors(
//                        cursorColor = Color.Black,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                    ),
//                    label = { BodyLargeRegular(value = "1")} // Add content description
//                )
//
//                TextField(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(horizontal = 4.dp)
//                        .background(Color.Transparent),
//                    value = verificationCodeSecond,
//                    onValueChange = { verificationCodeSecond = it.filter { it.isDigit() }.take(1) },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                    colors = TextFieldDefaults.colors(
//                        cursorColor = Color.Black,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                    ),
//                    label = { BodyLargeRegular(value = "2") } // Add content description
//                )
//
//                TextField(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(horizontal = 4.dp)
//                        .background(Color.Transparent),
//                    value = verificationCodeThird,
//                    onValueChange = { verificationCodeThird = it.filter { it.isDigit() }.take(1) },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                    colors = TextFieldDefaults.colors(
//                        cursorColor = Color.Black,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent
//                    ),
//                    label = { BodyLargeRegular(value = "3") } // Add content description
//                )
//
//                TextField(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(start = 4.dp)
//                        .background(Color.Transparent),
//                    value = verificationCodeLast,
//                    onValueChange = { verificationCodeLast = it.filter { it.isDigit() }.take(1) },
//                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//                    colors = TextFieldDefaults.colors(
//                        cursorColor = Color.Black,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent
//                    ),
//                    label = { BodyLargeRegular(value = "4") } // Add content description
//                )
//            }
//            if (errorMessage.isNotEmpty()) {
//                ErrorBodySmallRegular(value = errorMessage)
//            }
//            LargerSpacer
//            Button(onClick = {
//                val enteredCode = "$verificationCodeFirst$verificationCodeSecond$verificationCodeThird$verificationCodeLast"
//                retrieveVerificationCode(email) { verificationCode ->
//                    // Callback function invoked when verification code is retrieved
//                    if (verificationCode != null && verifyUserCode(enteredCode, verificationCode)) {
//                        // Verification successful, navigate to the next screen
//                        navController.navigate(Routes.VerificationSuccessRoute)
//                    } else {
//                        // Incorrect verification code, display error message
//                        errorMessage = "Incorrect verification code"
//                    }
//                }
//            },
//                enabled = !areFieldsEmpty(),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = PrimaryHoverNormal,
//                    contentColor = Color.White,
//                    disabledContainerColor = TransparentColor,
//                    disabledContentColor = Color.White
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 16.dp)
//            ) {
//                BodyLargeRegular(value = "Verify")
//            }
//        }
//    }
//}
