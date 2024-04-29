package com.techdetect.digisecure.main_app_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes
import com.techdetect.digisecure.app_components.BodyLargeRegular
import com.techdetect.digisecure.app_components.BodyLargeRegularLight
import com.techdetect.digisecure.app_components.MediumSpacer
import com.techdetect.digisecure.app_components.SmallSpacer
import com.techdetect.digisecure.app_components.horizontalMediumSpacer
import com.techdetect.digisecure.app_components.horizontalMiniSpacer
import com.techdetect.digisecure.ui.theme.DarkButtonColor
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormal
import com.techdetect.digisecure.ui.theme.PrimaryGreenNormalActive
import com.techdetect.digisecure.ui.theme.PrimaryHoverDark
import com.techdetect.digisecure.ui.theme.PrimaryHoverLight

@Composable
fun MenuPage(navController: NavController) {
    var isDropdownMenuOpen by remember { mutableStateOf(false) } // State to track if dropdown menu is open

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(PrimaryHoverLight)
            .padding(horizontal = 16.dp, vertical = 48.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DropdownMenuItem(
                image = {
                    Image(
                        painter = painterResource(id = R.drawable.new_logo),
                        contentDescription = null,
                        modifier = Modifier.size(120.dp) // Adjust image size here
                    )
                },

                text = "My Account"
            ) {
                isDropdownMenuOpen = !isDropdownMenuOpen // Toggle the dropdown menu state
            }

            // Show dropdown menu only when it's open
            if (isDropdownMenuOpen) {
                Spacer(modifier = Modifier.height(16.dp))
                DropdownMenuItem1(navController = navController)
                Spacer(modifier = Modifier.height(16.dp))
                DropdownMenuItem2(
                    text = "Manage Devices",
                    dropdownItems = listOf("Item 1", "Item 2", "Item 3"), // Example dropdown items
                ) { selectedItem ->
                    // Handle selected item
                }
                Spacer(modifier = Modifier.height(16.dp))
                DropdownMenuItem3(
                    text = "Security Tips",
                    dropdownItems = listOf("Item 1", "Item 2", "Item 3"), // Example dropdown items
                ) { selectedItem ->
                    // Handle selected item
                }
                Spacer(modifier = Modifier.height(16.dp))

                DropdownMenuItem4(
                    text = "Settings & Privacy",
                    dropdownItems = listOf("Item 1", "Item 2", "Item 3"), // Example dropdown items
                ) { selectedItem ->
                    // Handle selected item
                }
            }
        }
    }
}

@Composable
fun DropdownMenuItem(image: @Composable () -> Unit, text: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        color = DarkButtonColor
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = PrimaryHoverLight
                )
                horizontalMiniSpacer
                BodyLargeRegularLight(value = text)
            }
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Default.KeyboardDoubleArrowDown,
                    modifier = Modifier.size(24.dp),
                    contentDescription = null,
                    tint = PrimaryHoverLight
                )
            }
        }
    }
}

@Composable
fun DropdownMenuItem1(navController: NavController) {
    Button(
        onClick = {navController.navigate(Routes.RegisterDeviceScreenRoute)},
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryGreenNormalActive,
        ),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        BodyLargeRegularLight(value = "Register Device")
    }
}

@Composable
fun DropdownMenuItem2(
    text: String,
    dropdownItems: List<String>,
    onItemSelected: (String) -> Unit
) {
    var isDropdownMenuOpen by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        color = PrimaryGreenNormalActive
    ) {
        Column {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLargeRegularLight(value = text)
                IconButton(onClick = { isDropdownMenuOpen = !isDropdownMenuOpen }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        modifier = Modifier.size(24.dp),
                        contentDescription = null,
                        tint = PrimaryHoverLight
                    )
                }
            }
            // Dropdown list
            if (isDropdownMenuOpen) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                    color = PrimaryHoverLight
                ) {
                    Column {
                        dropdownItems.forEach { item ->
                            TextButton(
                                onClick = {
                                    onItemSelected(item)
                                    isDropdownMenuOpen = false
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownMenuItem3(
    text: String,
    dropdownItems: List<String>,
    onItemSelected: (String) -> Unit
) {
    var isDropdownMenuOpen by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        color = PrimaryGreenNormalActive
    ) {
        Column {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLargeRegularLight(value = text)
                IconButton(onClick = { isDropdownMenuOpen = !isDropdownMenuOpen }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        modifier = Modifier.size(24.dp),
                        contentDescription = null,
                        tint = PrimaryHoverLight
                    )
                }
            }
            // Dropdown list
            if (isDropdownMenuOpen) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                    color = PrimaryHoverLight
                ) {
                    Column {
                        dropdownItems.forEach { item ->
                            TextButton(
                                onClick = {
                                    onItemSelected(item)
                                    isDropdownMenuOpen = false
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownMenuItem4(
    text: String,
    dropdownItems: List<String>,
    onItemSelected: (String) -> Unit
) {
    var isDropdownMenuOpen by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        color = PrimaryGreenNormalActive
    ) {
        Column {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BodyLargeRegularLight(value = text)
                IconButton(onClick = { isDropdownMenuOpen = !isDropdownMenuOpen }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        modifier = Modifier.size(24.dp),
                        contentDescription = null,
                        tint = PrimaryHoverLight
                    )
                }
            }
            // Dropdown list
            if (isDropdownMenuOpen) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                    color = PrimaryHoverLight
                ) {
                    Column {
                        dropdownItems.forEach { item ->
                            TextButton(
                                onClick = {
                                    onItemSelected(item)
                                    isDropdownMenuOpen = false
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
            }
        }
    }
}