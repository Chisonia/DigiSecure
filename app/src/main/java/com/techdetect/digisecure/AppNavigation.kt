package com.techdetect.digisecure
import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.techdetect.digisecure.main_app_screens.HomeScreen
import com.techdetect.digisecure.main_app_screens.MenuPage
import com.techdetect.digisecure.main_app_screens.RegisterDeviceScreen
import com.techdetect.digisecure.view_models.AuthViewModel
import com.techdetect.digisecure.screens.onboarding.DecisionScreen
import com.techdetect.digisecure.screens.onboarding.PasswordRecoveryScreen
import com.techdetect.digisecure.screens.onboarding.ResetPasswordScreen
import com.techdetect.digisecure.screens.onboarding.ResetSuccessMessage
import com.techdetect.digisecure.screens.onboarding.SignInScreen
import com.techdetect.digisecure.screens.onboarding.SignUpCompScreen
import com.techdetect.digisecure.screens.onboarding.SignUpScreen
import com.techdetect.digisecure.screens.onboarding.SplashScreen
import com.techdetect.digisecure.screens.onboarding.VerificationSuccessMessage

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavigation(context: Context,
                  currentLocation: LatLng,
                  cameraPositionState: CameraPositionState,
                  startLocationUpdates: () -> Unit,
) {
    val navController = rememberNavController()
    val savedState = navController.currentBackStackEntryAsState().value?.savedStateHandle
    val userEmail = savedState?.get<String>("userEmail")
    val userName = ""

    NavHost(
        navController = navController,
        startDestination = Routes.SplashRoute,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = Routes.SplashRoute) {
            SplashScreen(navController)
        }

        composable(route = Routes.DecisionRoute) {
            DecisionScreen(navController)
        }
        composable(route = Routes.SignInRoute) {
            val authViewModel: AuthViewModel = viewModel()
            SignInScreen(navController, authViewModel)
        }
        composable(route = Routes.SignUpRoute) {
            val authViewModel: AuthViewModel = viewModel()
            SignUpScreen(navController, authViewModel)
        }
        composable(route = Routes.SignUpCompRoute) {
            val authViewModel: AuthViewModel = viewModel()
            SignUpCompScreen(navController, authViewModel)
        }
        composable(route = Routes.PasswordRecoveryRoute) {
            val authViewModel: AuthViewModel = viewModel()
            PasswordRecoveryScreen(navController, authViewModel)
        }
        composable(route = Routes.ResetPasswordRoute) {
            val authViewModel: AuthViewModel = viewModel()
            ResetPasswordScreen(navController, authViewModel)
        }
        composable(route = Routes.ResetSuccessRoute) {
            ResetSuccessMessage(navController)
        }
//        composable(route = Routes.VerificationRoute) {
//            if (userEmail != null) {
//                VerificationScreen(navController, email = userEmail)
//            }
//        }
        composable(route = Routes.VerificationSuccessRoute) {
            VerificationSuccessMessage(navController)
        }

        composable(route = Routes.HomeScreenRoute) {
            HomeScreen(navController, userName)
        }
//        composable(route = Routes.AccountScreenRoute) {
//            val authViewModel: AuthViewModel = viewModel()
//            AccountScreen(navController, userName, authViewModel)
//        }

        composable(route = Routes.RegisterDeviceScreenRoute) {
            RegisterDeviceScreen(context, navController)
        }
        composable(route = Routes.MenuPageRoute) {
            MenuPage( navController)
        }
    }
}