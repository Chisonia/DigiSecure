package com.techdetect.digisecure.main_app_screens

import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.BodyMediumMedium
import com.techdetect.digisecure.app_components.BodySmallRegular
import com.techdetect.digisecure.app_components.ErrorBodySmallRegular
import com.techdetect.digisecure.app_components.LargeSpacer
import com.techdetect.digisecure.app_components.LargerSpacer
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.componentShape
import com.techdetect.digisecure.app_components.horizontalSmallSpacer
import com.techdetect.digisecure.ui.theme.DarkButtonColor
import com.techdetect.digisecure.ui.theme.DisableColor
import com.techdetect.digisecure.ui.theme.PrimaryGreenLight
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight
import com.techdetect.digisecure.ui.theme.WarningColor
import okhttp3.internal.http2.ErrorCode

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDeviceScreen(
    context: Context,
    navController: NavController,
) {
    var phoneName by remember { mutableStateOf("") }
    var modelNumber by remember { mutableStateOf("") }
    var serialNumber by remember { mutableStateOf("") }
    var registrationSuccessful by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val firestore = Firebase.firestore

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Register Device") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryHoverLight,
                    actionIconContentColor = PrimaryHoverDark
                )
            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues = PaddingValues(all = 16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                LargerSpacer
                // TextFields for collecting device information
                OutlinedTextField(
                    value = phoneName,
                    onValueChange = { phoneName = it },
                    placeholder = { BodyMediumMedium(value = "Phone Model Name") },
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
                OutlinedTextField(
                    value = modelNumber,
                    onValueChange = { modelNumber = it },
                    placeholder = { BodyMediumMedium(value = "Model Number") },
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

                OutlinedTextField(
                    value = serialNumber,
                    onValueChange = { serialNumber = it },
                    placeholder = { BodyMediumMedium(value = "Serial Number") },
                    shape = componentShape.large,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryGreenLight,
                        unfocusedBorderColor = PrimaryGreenLight,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = WarningColor,
                    ),
                    keyboardActions = KeyboardActions.Default,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(componentShape.large)
                        .border(0.dp, Color.Transparent)
                        .background(PrimaryGreenLight)
                )
                BodySmallRegular(
                    value = "Check your 'About Phone' in phone settings," +
                            " for the above details")
// Display error message if present
                if (errorMessage.isNotEmpty()) {
                    ErrorBodySmallRegular(value = errorMessage)
                }
                LargeSpacer
                Button(
                    onClick = {
                        if (phoneName.isEmpty() || modelNumber.isEmpty() || serialNumber.isEmpty()) {
                            // At least one field is empty, show error message
                            errorMessage = "All fields are required"
                        } else {
                            // All fields are filled, proceed with registration
                            val device = hashMapOf(
                                "phoneName" to phoneName,
                                "modelNumber" to modelNumber,
                                "serialNumber" to serialNumber
                            )

                            firestore.collection("devices")
                                .add(device)
                                .addOnSuccessListener {
                                    // Device information stored successfully
                                    registrationSuccessful = true
                                    // You can navigate to another screen or show a toast message
                                    Toast.makeText(context, "Device information has been stored successfully", Toast.LENGTH_SHORT).show()
                                    navController.navigate(Routes.MenuPageRoute)
                                }
                                .addOnFailureListener { e ->
                                    // Error occurred while storing device information
                                    // Show error message or handle the error
                                    errorMessage = "Device registration was not successful"
                                }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkButtonColor,
                        contentColor = Color.White,
                        disabledContainerColor = DisableColor,
                        disabledContentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    BodyLargeRegularLight(value = "Register Device")
                }
            }
        }
    )
}
