package com.techdetect.digisecure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techdetect.digisecure.screens.onboarding.PasswordRecoveryScreen
import com.techdetect.digisecure.screens.onboarding.ResetPasswordScreen
import com.techdetect.digisecure.screens.onboarding.ResetSuccessMessage
import com.techdetect.digisecure.screens.onboarding.SignInScreen
import com.techdetect.digisecure.screens.onboarding.SignUpScreen
import com.techdetect.digisecure.screens.onboarding.VerificationScreen
import com.techdetect.digisecure.screens.onboarding.VerificationSuccessMessage




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            SignInScreen()
        }
    }
}
