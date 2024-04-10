package com.techdetect.digisecure.models

import android.os.Handler
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.auth
import com.techdetect.digisecure.R
import com.techdetect.digisecure.Routes


class AuthViewModel: ViewModel() {
    var isUserAuthenticated = mutableStateOf(false)
    var errorMessage = mutableStateOf("")
    fun signInUser(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isUserAuthenticated.value = true
                } else {
                    errorMessage.value = task.exception?.message.toString()
                    Log.e("Sign In Not Successful", task.exception.toString())
                }
            }
    }

    fun resetPassword(email: String, navController: NavHostController) {
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(Routes.PasswordRecoveryRoute)
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
        navController: NavController
    ) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Firebase.auth.currentUser?.sendEmailVerification()
                        ?.addOnCompleteListener { emailVerificationTask ->
                            if (emailVerificationTask.isSuccessful) {
                                // Update user profile
                                val user = Firebase.auth.currentUser
                                val profileUpdates = UserProfileChangeRequest.Builder()
                                    .setDisplayName(username)
                                    .build()
                                user?.updateProfile(profileUpdates)
                                    ?.addOnCompleteListener { profileUpdateTask ->
                                        if (profileUpdateTask.isSuccessful) {
                                            Log.d("Profile Update", "Profile updated successfully")
                                        } else {
                                            errorMessage.value =
                                                profileUpdateTask.exception?.message
                                                    ?: "Profile update failed"
                                            Log.e(
                                                "Profile Update",
                                                "Profile update failed: ${profileUpdateTask.exception}"
                                            )
                                        }
                                    }
                                // Set user authentication state
                                isUserAuthenticated.value = true
                                // Navigate to another screen if needed
                                navController.navigate(Routes.VerificationSuccessRoute)
                            } else {
                                // User registration failed
                                errorMessage.value = task.exception?.message.toString()
                                Log.e("Registration Not Successful", task.exception.toString())
                            }
                        }

                    // Set a timeout for email verification
                    val timeout = 60 * 60 * 24 // 24 hours

// Create a handler for the timeout
                    val handler = Handler()
                    val runnable = Runnable {
                        // Handle the case where the user has not verified their email address within the timeout period
                        // ...
                    }

// Start the timeout
                    handler.postDelayed(runnable, timeout.toLong())


                    // Send a reminder email to the user
                    val user = Firebase.auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("Verification Email", "Reminder email sent successfully")
                            } else {
                                // Failed to send reminder email
                                Log.e(
                                    "Verification Email",
                                    "Failed to send reminder email: ${task.exception}"
                                )
                            }
                        }
                }
            }
    }


    fun registerCompUser(
        username: String,
        email: String,
        password: String,
        navController: NavController
    ) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Firebase.auth.currentUser?.sendEmailVerification()
                        ?.addOnCompleteListener { emailVerificationTask ->
                            if (emailVerificationTask.isSuccessful) {
                                // Update user profile
                                val user = Firebase.auth.currentUser
                                val profileUpdates = UserProfileChangeRequest.Builder()
                                    .setDisplayName(username)
                                    .build()
                                user?.updateProfile(profileUpdates)
                                    ?.addOnCompleteListener { profileUpdateTask ->
                                        if (profileUpdateTask.isSuccessful) {
                                            Log.d("Profile Update", "Profile updated successfully")
                                        } else {
                                            errorMessage.value =
                                                profileUpdateTask.exception?.message
                                                    ?: "Profile update failed"
                                            Log.e(
                                                "Profile Update",
                                                "Profile update failed: ${profileUpdateTask.exception}"
                                            )
                                        }
                                    }
                                // Set user authentication state
                                isUserAuthenticated.value = true
                                // Navigate to another screen if needed
                                navController.navigate(Routes.VerificationSuccessRoute)
                            } else {
                                // User registration failed
                                errorMessage.value = task.exception?.message.toString()
                                Log.e("Registration Not Successful", task.exception.toString())
                            }
                        }

                    // Set a timeout for email verification
                    val timeout = 60 * 60 * 24 // 24 hours

// Create a handler for the timeout
                    val handler = Handler()
                    val runnable = Runnable {
                        // Handle the case where the user has not verified their email address within the timeout period
                        // ...
                    }

// Start the timeout
                    handler.postDelayed(runnable, timeout.toLong())


                    // Send a reminder email to the user
                    val user = Firebase.auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("Verification Email", "Reminder email sent successfully")
                            } else {
                                // Failed to send reminder email
                                Log.e(
                                    "Verification Email",
                                    "Failed to send reminder email: ${task.exception}"
                                )
                            }
                        }
                }
            }
    }
}
