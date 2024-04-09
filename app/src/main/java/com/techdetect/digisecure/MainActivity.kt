package com.techdetect.digisecure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            window.statusBarColor = getColor(R.color.black)
           AppNavigation()
        }
    }
}
