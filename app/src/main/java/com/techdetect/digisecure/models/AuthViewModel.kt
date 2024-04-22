package com.techdetect.digisecure.models

import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import com.techdetect.digisecure.Routes


class AuthViewModel: ViewModel() {
    private var isUserAuthenticated = mutableStateOf(false)
    private var errorMessage = mutableStateOf("")
    var signInErrorMessage = mutableStateOf("")
    fun signInUser(email: String, password: String, navController: NavController) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isUserAuthenticated.value = true
                    try {
                        navController.navigate(Routes.HomeScreenRoute)
                        Log.d("Navigation", "Navigated to home screen")
                    } catch (e: Exception) {
                        Log.e("Navigation", "Error navigating to home screen", e)
                    }
                } else {
                    signInErrorMessage.value = task.exception?.message.toString()
                    Log.e("Sign In Not Successful", task.exception.toString())
                }
            }
    }

    fun resetPassword(email: String, navController: NavHostController) {
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(Routes.ResetSuccessRoute)
            } else {
                errorMessage.value = task.exception?.message.toString()
                Log.e("Reset Password Not Successful", task.exception.toString())
            }
        }
    }


    //    fun signOut() {
//        Firebase.auth.signOut()
//        isUserAuthenticated.value = false // Update the user authentication state
//    }



    fun registerUser(
        username: String,
        email: String,
        password: String,
        navController: NavController,
        authErrorMessage: MutableLiveData<String> // assuming you have this LiveData to communicate errors to the UI
    ) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { createUserTask ->
                if (createUserTask.isSuccessful) {
                    val user = FirebaseAuth.getInstance().currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(username)
                        .build()
                    user?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { profileUpdateTask ->
                            if (profileUpdateTask.isSuccessful) {
                                Log.d("Profile Update", "Profile updated successfully")
                                sendEmailVerification(navController)
                            } else {
                                // Profile update failed
                                authErrorMessage.value = "Failed to update profile"
                                Log.e("Profile Update", "Profile update failed: ${profileUpdateTask.exception}")
                            }
                        }
                } else {
                    // User registration failed
                    authErrorMessage.value = createUserTask.exception?.message.toString()
                    Log.e("Registration Not Successful", "User registration failed: ${createUserTask.exception}")
                }
            }
    }

    private fun sendEmailVerification(navController: NavController) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        currentUser?.sendEmailVerification()
            ?.addOnCompleteListener { verificationTask ->
                if (verificationTask.isSuccessful) {
                    Log.d("Verification Email", "Verification email sent")
                    // Navigate to verification success screen
                    navController.navigate(Routes.VerificationSuccessRoute)
                    startVerificationLinkTimer(navController)
                } else {
                    Log.e("Verification Email", "Failed to send verification email: ${verificationTask.exception}")
                    // Show an error message to the user
                    Toast.makeText(navController.context, "Failed to send verification email", Toast.LENGTH_LONG).show()
                    // You can handle the error case here, such as showing a message to the user or retrying the verification email
                }
            }
    }

    private fun startVerificationLinkTimer(navController: NavController) {
        val verificationLinkTimeoutMillis = 24 * 60 * 60 * 1000 // 24 hours
        object : CountDownTimer(verificationLinkTimeoutMillis.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Timer is counting down
                val secondsRemaining = millisUntilFinished / 1000
                Log.d("Verification Link Timer", "Seconds remaining: $secondsRemaining")
                // Update UI if needed to display the remaining time
            }

            override fun onFinish() {
                // Timer has finished, verification link expired
                Log.d("Verification Link Timer", "Verification link expired")
                // Show a message to the user
                Toast.makeText(navController.context, "Verification link has expired", Toast.LENGTH_LONG).show()
                // You can navigate to another screen or perform any other action here based on your app's logic
            }
        }.start()
    }
//    private fun sendVerificationEmail(email: String, navController: NavController) {
//        val verificationCode = generateVerificationCode() // Generate verification code
//        AuthenticationManager.sendVerificationCode(email, verificationCode)
//        // Navigate to the verification screen with the NavController
//        navController.navigate(Routes.VerificationRoute)
//    }

//    private fun generateVerificationCode(): String {
//        // Generate a random 6-digit verification code
//        return (100000..999999).random().toString()
//    }
}
