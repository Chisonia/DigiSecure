package com.techdetect.digisecure.app_components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ForgotPassword(){
    Row (
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()
    ){
        TextButton(
            onClick = {},
            modifier = Modifier
                .padding(bottom = 20.dp)

        ) {
            BodySmallMedium(value = "Forgot Password?")

        }
    }
}