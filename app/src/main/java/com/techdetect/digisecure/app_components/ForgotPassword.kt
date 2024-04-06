package com.techdetect.digisecure.app_components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techdetect.digisecure.Routes


@Composable
fun ForgotPassword(navController: NavHostController){
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
}