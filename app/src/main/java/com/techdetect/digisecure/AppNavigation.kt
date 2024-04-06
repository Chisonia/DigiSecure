//package com.techdetect.digisecure
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.composable
//import com.techdetect.digisecure.screens.onboarding.PasswordRecoveryScreen
//import com.techdetect.digisecure.screens.onboarding.ResetPasswordScreen
//import com.techdetect.digisecure.screens.onboarding.ResetSuccessMessage
//import com.techdetect.digisecure.screens.onboarding.SignInScreen
//import com.techdetect.digisecure.screens.onboarding.SignUpScreen
//import com.techdetect.digisecure.screens.onboarding.VerificationScreen
//import com.techdetect.digisecure.screens.onboarding.VerificationSuccessMessage
//
//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = Routes.SplashRoute
//    ) {
//        composable(Routes.SplashRoute) {
//            SplashScreen(navController)
//        }
//        composable(Routes.SignInRoute) {
//            SignInScreen(navController)
//        }
//        composable(Routes.SignUpRoute) {
//            SignUpScreen(navController)
//        }
//        composable(Routes.PasswordRecoveryRoute) {
//            PasswordRecoveryScreen(navController)
//        }
//        composable(Routes.ResetPasswordRoute) {
//            ResetPasswordScreen(navController)
//        }
//        composable(Routes.ResetSuccessRoute) {
//            ResetSuccessMessage(navController)
//        }
//        composable(Routes.VerificationRoute) {
//            VerificationScreen(navController)
//        }
//        composable(Routes.VerificationSuccessRoute) {
//            VerificationSuccessMessage(navController)
//        }
//    }
//}