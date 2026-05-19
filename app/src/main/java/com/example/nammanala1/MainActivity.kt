package com.example.nammanala1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Redirect to HomeActivity as it's the main entry point now
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
