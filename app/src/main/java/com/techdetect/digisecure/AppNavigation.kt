package com.techdetect.digisecure
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techdetect.digisecure.models.AuthViewModel
import com.techdetect.digisecure.screens.onboarding.DecisionScreen
import com.techdetect.digisecure.screens.onboarding.PasswordRecoveryScreen
import com.techdetect.digisecure.screens.onboarding.ResetPasswordScreen
import com.techdetect.digisecure.screens.onboarding.ResetSuccessMessage
import com.techdetect.digisecure.screens.onboarding.SignInScreen
import com.techdetect.digisecure.screens.onboarding.SignUpCompScreen
import com.techdetect.digisecure.screens.onboarding.SignUpScreen
import com.techdetect.digisecure.screens.onboarding.SplashScreen
import com.techdetect.digisecure.screens.onboarding.VerificationScreen
import com.techdetect.digisecure.screens.onboarding.VerificationSuccessMessage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = Routes.SplashRoute,
        modifier = Modifier.fillMaxSize() // Optionally, specify modifier if needed
    ) {
        composable(route = Routes.SplashRoute) {
            SplashScreen(navController)
        }

        composable(route = Routes.DecisionRoute) {
            DecisionScreen(navController)
        }
        composable(route = Routes.SignInRoute) {
            SignInScreen(navController, authViewModel)
        }
        composable(route = Routes.SignUpRoute) {
            SignUpScreen(navController, authViewModel)
        }
        composable(route = Routes.SignUpCompRoute) {
            SignUpCompScreen(navController, authViewModel)
        }
        composable(route = Routes.PasswordRecoveryRoute) {
            PasswordRecoveryScreen(navController, authViewModel)
        }
        composable(route = Routes.ResetPasswordRoute) {
            ResetPasswordScreen(navController, authViewModel)
        }
        composable(route = Routes.ResetSuccessRoute) {
            ResetSuccessMessage(navController)
        }
        composable(route = Routes.VerificationRoute) {
            VerificationScreen(navController)
        }
        composable(route = Routes.VerificationSuccessRoute) {
            VerificationSuccessMessage(navController)
        }
    }
}