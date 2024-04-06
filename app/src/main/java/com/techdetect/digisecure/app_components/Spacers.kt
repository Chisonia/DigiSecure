package com.techdetect.digisecure.app_components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
val MiniSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(4.dp))
val SmallSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(8.dp))

val MediumSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(16.dp))
val LargeSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(32.dp))
val LargerSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(64.dp))

val LargestSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.height(128.dp))

val horizontalMiniSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(4.dp))
val horizontalSmallSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(8.dp))

val horizontalMediumSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(16.dp))
val horizontalLargeSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(32.dp))
val horizontalLargerSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(64.dp))

val horizontalLargestSpacer: Unit
    @Composable
    get() = Spacer(modifier = Modifier.width(128.dp))