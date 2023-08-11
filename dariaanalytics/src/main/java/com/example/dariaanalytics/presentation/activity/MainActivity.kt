package com.example.dariaanalytics.presentation.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun initialize(context: Context) {
        // Perform any initialization tasks here
        // For example, initialize Firebase Analytics
        // FirebaseApp.initializeApp(context)
    }
}