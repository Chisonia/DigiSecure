//package com.techdetect.digisecure
//
//import android.util.Log
//import com.google.android.gms.tasks.Task
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.DocumentSnapshot
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.SetOptions
//
//object AuthenticationManager {
//
//    fun sendVerificationCode(email: String, verificationCode: String) {
//        // Send verification code to user's email using Firebase Authentication
//        FirebaseAuth.getInstance().sendEmailVerificationCode()
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Verification email sent successfully
//                    // Store verification code in database along with user's email or user ID
//                    // For example, using Firebase Firestore:
//                    val db = FirebaseFirestore.getInstance()
//                    val userRef = db.collection("users").document(email)
//                    val data = hashMapOf(
//                        "verificationCode" to verificationCode
//                    )
//                    userRef.set(data, SetOptions.merge())
//                        .addOnSuccessListener {
//                            // Verification code stored successfully
//                        }
//                        .addOnFailureListener { e ->
//                            // Handle failure to store verification code
//                        }
//                } else {
//                    // Failed to send verification email
//                    // Handle error
//                }
//            }
//    }
//
////    fun retrieveVerificationCode(email: String, callback: (String?) -> Unit): Task<DocumentSnapshot> {
////        val db = FirebaseFirestore.getInstance()
////        val userRef = db.collection("users").document(email)
////
////        // Retrieve verification code associated with the user's email
////        return userRef.get().addOnCompleteListener { task ->
////            if (task.isSuccessful) {
////                val document = task.result
////                if (document != null && document.exists()) {
////                    val verificationCode = document.getString("verificationCode")
////                    callback(verificationCode)
////                } else {
////                    callback(null) // Document doesn't exist or is empty
////                }
////            } else {
////                // Handle errors here
////                callback(null)
////                Log.e("Firestore", "Error retrieving verification code: ${task.exception}")
////            }
////        }
////    }
////
////    fun verifyUserCode(enteredCode: String, storedCode: String): Boolean {
////        // Compare the entered code with the stored verification code
////        return enteredCode == storedCode
////    }
//}